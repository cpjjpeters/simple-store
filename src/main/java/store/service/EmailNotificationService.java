package store.service;

/* carlpeters created on 28/03/2025 inside the package - store.service */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {

    @Value("${mail.host")
    private String host;
    @Value("${mail.port}")
    private String port;



    @Override
    public void sendNotification(String message, String recipientEmail) {
        System.out.println("Sending email notification...");
        System.out.println("Message: " + message);
        System.out.println("Recipient: " + recipientEmail);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);


    }
}
