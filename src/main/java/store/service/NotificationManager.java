package store.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/* carlpeters created on 28/03/2025 inside the package - store.service */
@Service
public class NotificationManager {

    private final NotificationService notificationService;

    public NotificationManager(@Qualifier("sms") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message, String recipient) {
        notificationService.sendNotification(message, recipient);
    }
}
