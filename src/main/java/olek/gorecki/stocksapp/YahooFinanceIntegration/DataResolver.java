package olek.gorecki.stocksapp.YahooFinanceIntegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DataResolver {
    private static final Logger logger = LoggerFactory.getLogger(DataResolver.class);

    @Scheduled(fixedDelay = 5356800)
    public void getStockStatstics() throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?function=GLOBAL_QUOTE&symbol=MSFT&datatype=json"))
//                .header("x-rapidapi-key", "d47b5a81aemsh6a359df7fd55316p1a0c1ejsn46c60ffa4c24")
//                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        logger.info(response.body());
    }
}
