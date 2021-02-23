package olek.gorecki.stocksapp.stock;

import olek.gorecki.stocksapp.stock_stats.StockStatistics;
import olek.gorecki.stocksapp.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name="STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ticker must be specified")
    private String ticker;

    @NotNull(message = "open price must be specified")
    private float openPrice;

    @NotBlank(message = "action must be specified")
    @Pattern(regexp = "[bsBS]", message = "action must b buy(B,b) or sell(S,s)")
    private String action;

    @NotBlank(message = "full name must be specified")
    private String fullName;

    private String category = "none";
    private boolean stillOpen = true;
    @NotNull(message = "money value must be specified")
    private Float moneyValue;
    private Long leverage = 1L;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private Set<StockStatistics> stockStatistics;

    public Stock() {
    }

    public void addStockStatistic(StockStatistics stockStatistics) {
        this.stockStatistics.add(stockStatistics);
        stockStatistics.setStock(this);
    }

    public Float getMoneyValue() {
        return moneyValue;
    }

    public Long getLeverage() {
        return leverage;
    }

    public void setLeverage(Long leverage) {
        this.leverage = leverage;
    }

    public void setMoneyValue(Float moneyValue) {
        this.moneyValue = moneyValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isStillOpen() {
        return stillOpen;
    }

    public void setStillOpen(boolean stillOpen) {
        this.stillOpen = stillOpen;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<StockStatistics> getStockStatistics() {
        return stockStatistics;
    }

    public void setStockStatistics(Set<StockStatistics> stockStatistics) {
        this.stockStatistics = stockStatistics;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
