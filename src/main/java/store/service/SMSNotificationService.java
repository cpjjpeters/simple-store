package store.service;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending SMS notification...");
        System.out.println("Message: " + message);
        System.out.println("Recipient: " + recipient);
    }
}
