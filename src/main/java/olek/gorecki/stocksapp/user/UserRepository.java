package olek.gorecki.stocksapp.user;

import java.util.Optional;

public interface UserRepository {
    User findByUsername(String username);

    void deleteAll();

    User save(User user);

    Optional<User> findById(Long id);
}
