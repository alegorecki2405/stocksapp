package olek.gorecki.stocksapp.stock;

import olek.gorecki.stocksapp.stock_stats.StockStatistics;
import olek.gorecki.stocksapp.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "ticker must be specified")
    private String ticker;
    private float openPrice;
    private char action;
    private String fullName;
    private String category;
    private boolean stillOpen;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "stock")
    private Set<StockStatistics> stockStatistics;

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    private String getTicker() {
        return ticker;
    }

    private void setTicker(String ticker) {
        this.ticker = ticker;
    }

    private float getOpenPrice() {
        return openPrice;
    }

    private void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    private char getAction() {
        return action;
    }

    private void setAction(char action) {
        this.action = action;
    }

    private String getFullName() {
        return fullName;
    }

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String getCategory() {
        return category;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    private boolean isStillOpen() {
        return stillOpen;
    }

    private void setStillOpen(boolean stillOpen) {
        this.stillOpen = stillOpen;
    }

    private User getUser() {
        return user;
    }

    private void setUser(User user) {
        this.user = user;
    }
}
