package store.persistence;


import store.persistence.entities.User;

public interface UserRepository {

//    User findById(Long id);

    void save(User user);
    User findByEmail(String email);


//    void deleteById(Long id);
//
//    List<User> findAll();
//
//    User update(User user);


}
