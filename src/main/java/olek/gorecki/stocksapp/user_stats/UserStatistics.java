package olek.gorecki.stocksapp.user_stats;

import olek.gorecki.stocksapp.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USER_STATISTICS")
public class UserStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private float marketOpenMoneyValue;
    private float marketCloseMoneyValue;
    private float percentToday;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserStatistics() {
    }

    public float getPercentToday() {
        return percentToday;
    }

    public void setPercentToday(float percentToday) {
        this.percentToday = percentToday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getMarketOpenMoneyValue() {
        return marketOpenMoneyValue;
    }

    public void setMarketOpenMoneyValue(float marketOpen) {
        this.marketOpenMoneyValue = marketOpen;
    }

    public float getMarketCloseMoneyValue() {
        return marketCloseMoneyValue;
    }

    public void setMarketCloseMoneyValue(float marketClose) {
        this.marketCloseMoneyValue = marketClose;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
