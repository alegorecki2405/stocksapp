package olek.gorecki.stocksapp.stock_stats;

import olek.gorecki.stocksapp.stock.Stock;

import javax.persistence.*;

@Entity
@Table(name="STOCK_STATISTICS")
public class StockStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float current_price;
    private float open_price;
    private float close_price;
    private float money_value;

    @ManyToOne
    @JoinColumn(name="stock_id",nullable = false)
    private Stock stock;

    public StockStatistics() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(float current_price) {
        this.current_price = current_price;
    }

    public float getOpen_price() {
        return open_price;
    }

    public void setOpen_price(float open_price) {
        this.open_price = open_price;
    }

    public float getClose_price() {
        return close_price;
    }

    public void setClose_price(float close_price) {
        this.close_price = close_price;
    }

    public float getMoney_value() {
        return money_value;
    }

    public void setMoney_value(float money_value) {
        this.money_value = money_value;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
