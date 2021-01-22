package olek.gorecki.stocksapp.YahooFinanceIntegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataResolver {
    private static final Logger logger = LoggerFactory.getLogger(DataResolver.class);

    @Scheduled(fixedDelay = 5356800)
    public void getStockStatstics() {
        logger.info("stuff");
    }
}
