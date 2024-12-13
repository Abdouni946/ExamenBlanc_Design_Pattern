package org.example.aspects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AspectHandler implements InvocationHandler {

    private final Object target;
    private final Map<String, Object> cache = new HashMap<>(); // Cache local

    private static final List<String> currentUserRoles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");

    public AspectHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Log.class)) {
            long start = System.currentTimeMillis();
            Object result = method.invoke(target, args);
            long end = System.currentTimeMillis();
            System.out.println("Execution of " + method.getName() + " took " + (end - start) + " ms");
            return result;
        }

        if (method.isAnnotationPresent(Cachable.class)) {
            String key = method.getName() + Arrays.toString(args);
            if (cache.containsKey(key)) {
                System.out.println("Cache hit for method: " + method.getName());
                return cache.get(key);
            }
            System.out.println("Cache miss for method: " + method.getName());
            Object result = method.invoke(target, args);
            cache.put(key, result);
            return result;
        }

        if (method.isAnnotationPresent(SecuredBy.class)) {
            SecuredBy securedBy = method.getAnnotation(SecuredBy.class);
            String[] requiredRoles = securedBy.roles();
            boolean hasAccess = Arrays.stream(requiredRoles).anyMatch(currentUserRoles::contains);

            if (!hasAccess) {
                throw new SecurityException("Access denied for method: " + method.getName());
            }

            System.out.println("Access granted for method: " + method.getName());
        }

        return method.invoke(target, args);
    }
}
