package olek.gorecki.stocksapp.AlphaVantageIntegration;

import org.springframework.stereotype.Component;

@Component
public class DataResolver {
//    private static final Logger logger = LoggerFactory.getLogger(DataResolver.class);
//    private StockService stockService;
//    private StockStatisticsRepostiory stockStatisticsRepostiory;
//
//    public DataResolver(StockService stockService, StockStatisticsRepostiory stockStatisticsRepostiory) {
//        this.stockService = stockService;
//        this.stockStatisticsRepostiory = stockStatisticsRepostiory;
//    }
//
//    @Scheduled(fixedDelay = 300000000)
//    public void getStockStatstics() {
//        stockService.readAllStocks().forEach(stock -> {
//            try {
//                getStockStatsForToday(stock);
//            } catch (IOException | InterruptedException | JSONException e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//    private void getStockStatsForToday(Stock stock) throws IOException, InterruptedException, JSONException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?function=GLOBAL_QUOTE&symbol=" + stock.getTicker() + "&datatype=json"))
//                .header("x-rapidapi-key", "d47b5a81aemsh6a359df7fd55316p1a0c1ejsn46c60ffa4c24")
//                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        logger.info(response.body());
//        JSONObject result = new JSONObject(response.body());
//        JSONObject object = (JSONObject) result.get("Global Quote");
//        stockStatisticsRepostiory.save(createStaistic(stock, object));
//    }
//
//    private StockStatistics createStaistic(Stock stock, JSONObject object) throws JSONException {
//        StockStatistics stockStatistics = new StockStatistics();
//        stockStatistics.setStock(stock);
//        stockStatistics.setOpenPrice(Float.parseFloat(object.get("02. open").toString()));
//        stockStatistics.setClosePrice(Float.parseFloat(object.get("05. price").toString()));
//        stockStatistics.setHigh(Float.parseFloat(object.get("03. high").toString()));
//        stockStatistics.setLow(Float.parseFloat(object.get("04. low").toString()));
//        float moneyValue = (stockStatistics.getClosePrice() / stock.getOpenPrice()) * stock.getMoneyValue();
//        stockStatistics.setMoneyValue(moneyValue);
//        String date = object.get("07. latest trading day").toString();
//        stockStatistics.setDate(LocalDate.parse(date));
//        stockStatistics.setTime(LocalTime.now());
//        return stockStatistics;
//    }
}
