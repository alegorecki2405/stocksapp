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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Set<UserStatistics> getUserStatistics() {
        return userStatistics;
    }

    public void setUserStatistics(Set<UserStatistics> userStatistics) {
        this.userStatistics = userStatistics;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
}
