package olek.gorecki.stocksapp.stock;

public class StockReadModel {
    private String ticker;
    private float openPrice;
    private String action;
    private String fullName;
    private String category = "none";
    private boolean stillOpen = true;
    private Float moneyValue;
    private Long leverage;


    public StockReadModel(Stock stock) {
        this.ticker = stock.getTicker();
        this.openPrice = stock.getOpenPrice();
        this.action = stock.getAction();
        this.fullName = stock.getFullName();
        this.category = stock.getCategory();
        this.stillOpen = stock.isStillOpen();
        this.moneyValue = stock.getMoneyValue();
        this.leverage = stock.getLeverage();
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public Float getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(Float moneyValue) {
        this.moneyValue = moneyValue;
    }

    public Long getLeverage() {
        return leverage;
    }

    public void setLeverage(Long leverage) {
        this.leverage = leverage;
    }

}
