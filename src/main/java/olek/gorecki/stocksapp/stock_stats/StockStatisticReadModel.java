package olek.gorecki.stocksapp.stock_stats;

import java.time.LocalDate;
import java.time.LocalTime;

public class StockStatisticReadModel {
    private float closePrice;
    private float openPrice;
    private float high;
    private float low;
    private float moneyValue;
    private LocalDate date;
    private LocalTime time;

    public StockStatisticReadModel(StockStatistics stockStatistics) {
        this.closePrice = stockStatistics.getClosePrice();
        this.openPrice = stockStatistics.getOpenPrice();
        this.high = stockStatistics.getHigh();
        this.low = stockStatistics.getLow();
        this.moneyValue = stockStatistics.getMoneyValue();
        this.date = stockStatistics.getDate();
        this.time = stockStatistics.getTime();
    }

    public float getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(float closePrice) {
        this.closePrice = closePrice;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
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

    public void setMoneyValue(float moneyValue) {
        this.moneyValue = moneyValue;
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
}
