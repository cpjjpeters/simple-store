package store.service;

import store.model.User;
import store.persistence.UserRepository;

/* carlpeters created on 31/03/2025 inside the package - store.service */
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        System.out.println("Registering user: " + user.getUsername());
    }
}
