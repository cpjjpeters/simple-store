package store.service;

import store.model.User;
import store.persistence.UserRepository;

/* carlpeters created on 31/03/2025 inside the package - store.service */
public class InMemoryUserRepo implements UserRepository {
    @Override
    public User save(User user) {
        return user;
    }
}
