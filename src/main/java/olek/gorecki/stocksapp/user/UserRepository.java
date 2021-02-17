package olek.gorecki.stocksapp.user;

public interface UserRepository {
    User findByUsername(String username);

    void deleteAll();

    User save(User user);
}
