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

    private Long getId() {
        return id;
    }

    private float getCurrent_price() {
        return current_price;
    }

    private void setCurrent_price(float current_price) {
        this.current_price = current_price;
    }

    private float getOpen_price() {
        return open_price;
    }

    private void setOpen_price(float open_price) {
        this.open_price = open_price;
    }

    private float getClose_price() {
        return close_price;
    }

    private void setClose_price(float close_price) {
        this.close_price = close_price;
    }

    private float getMoney_value() {
        return money_value;
    }

    private void setMoney_value(float money_value) {
        this.money_value = money_value;
    }

    private Stock getStock() {
        return stock;
    }

    private void setStock(Stock stock) {
        this.stock = stock;
    }
}
