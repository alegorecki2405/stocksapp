package olek.gorecki.stocksapp.justtotestcontrollers;

import olek.gorecki.stocksapp.stock.StockService;
import olek.gorecki.stocksapp.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBinit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private StockService stockService;

    public DBinit(UserRepository userRepository, PasswordEncoder passwordEncoder, StockService stockService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.stockService = stockService;
    }

    @Override
    public void run(String... args) {
//        //Delete
//        this.userRepository.deleteAll();
//
//        //Create users
//        User olek = new User(1L, "aleksander", "górecki", "olobolo420", 123.0f, 1, "USER", "", passwordEncoder.encode("password"));
//        User mateusz = new User(2L, "mateusz", "woskowicz", "woskus", 100f, 1, "USER", "", passwordEncoder.encode("password"));
//        User admin = new User(3L, "admin", "admin", "admin", 0f, 1, "ADMIN", "", passwordEncoder.encode("password"));
//
//        //save users
//        userRepository.save(olek);
//        userRepository.save(mateusz);
//        userRepository.save(admin);
    }
}
