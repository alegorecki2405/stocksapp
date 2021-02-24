package olek.gorecki.stocksapp.AlphaVantageIntegration;

import olek.gorecki.stocksapp.stock.Stock;
import olek.gorecki.stocksapp.stock.StockRepository;
import olek.gorecki.stocksapp.stock.StockService;
import olek.gorecki.stocksapp.stock_stats.StockStatistics;
import olek.gorecki.stocksapp.stock_stats.StockStatisticsRepostiory;
import olek.gorecki.stocksapp.user.User;
import olek.gorecki.stocksapp.user.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;


@Component
public class DataResolver {
    private static final Logger logger = LoggerFactory.getLogger(DataResolver.class);
    private StockService stockService;
    private StockStatisticsRepostiory stockStatisticsRepostiory;
    private UserRepository userRepository;
    private StockRepository stockRepository;

    public DataResolver(StockService stockService, StockStatisticsRepostiory stockStatisticsRepostiory, UserRepository userRepository) {
        this.stockService = stockService;
        this.stockStatisticsRepostiory = stockStatisticsRepostiory;
        this.userRepository = userRepository;
    }

    //    @Scheduled(fixedDelay = 300000000)
    public void getStockStatstics() {
        userRepository.findAll().forEach(user -> {
            stockRepository.findAllByUser(user).forEach(stock -> {
                try {
                    getStockStatsForToday(stock, user);
                } catch (IOException | InterruptedException | JSONException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    private void getStockStatsForToday(Stock stock, User user) throws IOException, InterruptedException, JSONException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?function=GLOBAL_QUOTE&symbol=" + stock.getTicker() + "&datatype=json"))
                .header("x-rapidapi-key", user.getApiKey())
                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        logger.info(response.body());
        JSONObject result = new JSONObject(response.body());
        JSONObject object = (JSONObject) result.get("Global Quote");
        stockStatisticsRepostiory.save(createStaistic(stock, object));
    }

    private StockStatistics createStaistic(Stock stock, JSONObject object) throws JSONException {
        StockStatistics stockStatistics = new StockStatistics();
        stockStatistics.setStock(stock);
        stockStatistics.setOpenMarketPrice(Float.parseFloat(object.get("02. open").toString()));
        stockStatistics.setCloseMarketPrice(Float.parseFloat(object.get("05. price").toString()));
        stockStatistics.setHigh(Float.parseFloat(object.get("03. high").toString()));
        stockStatistics.setLow(Float.parseFloat(object.get("04. low").toString()));
        stockStatistics.setChangePercent(Float.parseFloat(object.get("10. change percent").toString()));
        float moneyValue = (stockStatistics.getCloseMarketPrice() / stock.getOpenPrice()) * stock.getMoneyValue();
        stockStatistics.setMoneyValue(moneyValue);
        String date = object.get("07. latest trading day").toString();
        stockStatistics.setDate(LocalDate.parse(date));
        stockStatistics.setTime(LocalTime.now());
        return stockStatistics;
    }
}
