package olek.gorecki.stocksapp.user_stats;

import olek.gorecki.stocksapp.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="USER_STATISTICS")
public class UserStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private float currentProfit;
    private float marketOpen;
    private float marketClose;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    public UserStatistics() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public float getCurrentProfit() {
        return currentProfit;
    }

    public void setCurrentProfit(float currentProfit) {
        this.currentProfit = currentProfit;
    }

    public float getMarketOpen() {
        return marketOpen;
    }

    public void setMarketOpen(float marketOpen) {
        this.marketOpen = marketOpen;
    }

    public float getMarketClose() {
        return marketClose;
    }

    public void setMarketClose(float marketClose) {
        this.marketClose = marketClose;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
