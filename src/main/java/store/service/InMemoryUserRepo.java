package store.service;

import org.springframework.stereotype.Repository;
import store.model.User;
import store.persistence.UserRepository;

import java.util.HashMap;

/* carlpeters created on 31/03/2025 inside the package - store.service */
@Repository
public class InMemoryUserRepo implements UserRepository {

    private final HashMap<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        System.out.println("Saving user: " + user.getUsername());
        users.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        return users.getOrDefault(email, null);
    }
}
