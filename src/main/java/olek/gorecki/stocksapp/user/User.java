package olek.gorecki.stocksapp.user;

import olek.gorecki.stocksapp.stock.Stock;
import olek.gorecki.stocksapp.user_stats.UserStatistics;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firsName;
    private String lastName;
    private String login;
    private float money;

    @OneToMany(mappedBy = "user")
    private Set<UserStatistics> userStatistics;

    @OneToMany(mappedBy = "user")
    private Set<Stock> stocks;

    public User() {
    }

    private Long getId() {
        return id;
    }

    private String getFirsName() {
        return firsName;
    }

    private void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    private String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String getLogin() {
        return login;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    private float getMoney() {
        return money;
    }

    private void setMoney(float money) {
        this.money = money;
    }
}
