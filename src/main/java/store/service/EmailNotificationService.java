package store.service;

/* carlpeters created on 28/03/2025 inside the package - store.service */
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending email notification...");
        System.out.println("Message: " + message);
        System.out.println("Recipient: " + recipient);

    }
}
