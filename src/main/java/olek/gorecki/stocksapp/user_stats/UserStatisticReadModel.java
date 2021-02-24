package olek.gorecki.stocksapp.user_stats;

import java.time.LocalDateTime;

public class UserStatisticReadModel {
    private LocalDateTime date;
    private float currentProfit;
    private float marketOpen;
    private float marketClose;

    public UserStatisticReadModel(UserStatistics userStatistics) {
        this.date = userStatistics.getDate();
        this.currentProfit = userStatistics.getCurrentProfit();
        this.marketOpen = userStatistics.getMarketOpen();
        this.marketClose = userStatistics.getMarketClose();
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
}
