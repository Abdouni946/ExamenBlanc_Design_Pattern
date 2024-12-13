package org.example.patterns.strategy;

import javax.management.Notification;

public interface NotificationStrategy {
    void processNotification(Notification notification);
    Object getResult(); // Résultat spécifique à chaque stratégie
}