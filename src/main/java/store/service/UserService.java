package store.service;

import org.springframework.stereotype.Service;
import store.model.User;
import store.persistence.UserRepository;

/* carlpeters created on 31/03/2025 inside the package - store.service */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("User already exists with email: " + user.getEmail());
            throw new IllegalArgumentException("User already exists with email: " + user.getEmail());
        }
        userRepository.save(user);
        notificationService.sendNotification("Welcome to our service!", user.getEmail());
        System.out.println("Registering user: " + user.getUsername());

    }
}
