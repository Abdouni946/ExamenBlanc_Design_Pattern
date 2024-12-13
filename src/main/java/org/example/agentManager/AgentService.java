package org.example.agentManager;

import org.example.aspects.Cachable;
import org.example.aspects.Log;
import org.example.aspects.SecuredBy;

public class AgentService {

    @Log
    public void performAction() {
        System.out.println("Performing action");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Cachable
    public String getMaxTransaction() {
        System.out.println("Calculating max transaction");
        return "Transaction with the highest amount";
    }

    @SecuredBy(roles = {"ROLE_ADMIN"})
    public void secureMethod() {
        System.out.println("Executing a secure method");
    }
}
