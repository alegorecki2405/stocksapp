package olek.gorecki.stocksapp.justtotestcontrollers;

import olek.gorecki.stocksapp.user.User;
import olek.gorecki.stocksapp.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DBinit implements CommandLineRunner {
    private UserRepository userRepository;


    public DBinit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Delete
        this.userRepository.deleteAll();

        //Create users
        User olek = new User(1L, "aleksander", "górecki", "olobolo420", 123.0f, 1, "USER", "", "password");
        User mateusz = new User(2L, "mateusz", "woskowicz", "woskus", 100f, 1, "USER", "", "password");
        User admin = new User(3L, "admin", "admin", "admin", 0f, 1, "ADMIN", "", "password");

        //save users
        userRepository.save(olek);
        userRepository.save(mateusz);
        userRepository.save(admin);
    }
}
