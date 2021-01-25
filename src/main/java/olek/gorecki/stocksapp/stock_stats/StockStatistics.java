package olek.gorecki.stocksapp.stock_stats;

import olek.gorecki.stocksapp.stock.Stock;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "STOCK_STATISTICS")
public class StockStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float closePrice;
    private float openPrice;
    private float high;
    private float low;
    private float moneyValue;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public StockStatistics() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(float current_price) {
        this.closePrice = current_price;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float open_price) {
        this.openPrice = open_price;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(float money_value) {
        this.moneyValue = money_value;
    }

    private Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
