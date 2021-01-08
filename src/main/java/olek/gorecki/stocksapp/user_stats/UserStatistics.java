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

    private Long getId() {
        return id;
    }

    private LocalDateTime getDate() {
        return date;
    }

    private void setDate(LocalDateTime date) {
        this.date = date;
    }

    private float getCurrentProfit() {
        return currentProfit;
    }

    private void setCurrentProfit(float currentProfit) {
        this.currentProfit = currentProfit;
    }

    private float getMarketOpen() {
        return marketOpen;
    }

    private void setMarketOpen(float marketOpen) {
        this.marketOpen = marketOpen;
    }

    private float getMarketClose() {
        return marketClose;
    }

    private void setMarketClose(float marketClose) {
        this.marketClose = marketClose;
    }

    private User getUser() {
        return user;
    }

    private void setUser(User user) {
        this.user = user;
    }
}
