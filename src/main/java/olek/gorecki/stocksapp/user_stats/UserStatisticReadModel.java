package olek.gorecki.stocksapp.user_stats;

import java.time.LocalDate;

public class UserStatisticReadModel {
    private LocalDate date;
    private float marketOpenMoneyValue;
    private float marketCloseMoneyValue;
    private float percentToday;

    public UserStatisticReadModel(UserStatistics userStatistics) {
        this.date = userStatistics.getDate();
        this.marketOpenMoneyValue = userStatistics.getMarketOpenMoneyValue();
        this.marketCloseMoneyValue = userStatistics.getMarketCloseMoneyValue();
        this.percentToday = userStatistics.getPercentToday();
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

    public void setMarketOpenMoneyValue(float marketOpenMoneyValue) {
        this.marketOpenMoneyValue = marketOpenMoneyValue;
    }

    public float getMarketCloseMoneyValue() {
        return marketCloseMoneyValue;
    }

    public void setMarketCloseMoneyValue(float marketCloseMoneyValue) {
        this.marketCloseMoneyValue = marketCloseMoneyValue;
    }

    public float getPercentToday() {
        return percentToday;
    }

    public void setPercentToday(float percentToday) {
        this.percentToday = percentToday;
    }
}
