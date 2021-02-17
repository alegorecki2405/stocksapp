package olek.gorecki.stocksapp.user;

import olek.gorecki.stocksapp.stock.Stock;
import olek.gorecki.stocksapp.user_stats.UserStatistics;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firsName;
    private String lastName;
    private String username;
    private float money;
    private int active;
    private String roles;
    private String permissions;
    private String password;

    public User(Long id,
                String firsName,
                String lastName,
                String username,
                float money,
                int active,
                String roles,
                String permissions,
                String password) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.username = username;
        this.money = money;
        this.active = active;
        this.roles = roles;
        this.permissions = permissions;
        this.password = password;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
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

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
