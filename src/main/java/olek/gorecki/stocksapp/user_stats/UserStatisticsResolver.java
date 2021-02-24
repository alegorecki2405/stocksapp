package olek.gorecki.stocksapp.user_stats;

import olek.gorecki.stocksapp.stock.StockRepository;
import olek.gorecki.stocksapp.stock_stats.StockStatistics;
import olek.gorecki.stocksapp.stock_stats.StockStatisticsRepostiory;
import olek.gorecki.stocksapp.user.User;
import olek.gorecki.stocksapp.user.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserStatisticsResolver {
    private UserRepository userRepository;
    private StockRepository stockRepository;
    private UserStatisticsService userStatisticsService;
    private StockStatisticsRepostiory stockStatisticsRepostiory;

    public UserStatisticsResolver(UserRepository userRepository, StockRepository stockRepository) {
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
    }

    @Scheduled(cron = "0 22 ? * MON-FRI")
    public void resolveDataforUser() {
        userRepository.findAll().forEach(user -> {
            resolve(user);
        });
    }

    public void resolve(User user) {
        UserStatistics userStatistics = new UserStatistics();
        userStatistics.setDate(LocalDate.now());
        userStatistics.getMarketOpenMoneyValue();

        userStatisticsService.createUserStatistic(null, user);
    }

    public float marketOpenSum(User user) {
        double marketOpenMoneyValueProfit = stockRepository.findAllByUser(user).stream().mapToDouble(stock -> {
            StockStatistics stockStatistics = stockStatisticsRepostiory.findByStockAndDate(stock, LocalDate.now());
            double marketOpenForStockMoneyValue =
                    ((stockStatistics.getOpenMarketPrice() / stock.getOpenPrice())
                            * stock.getMoneyValue() * stock.getLeverage()) - stock.getMoneyValue();
            return marketOpenForStockMoneyValue;
        }).sum();
        return (float) marketOpenMoneyValueProfit;
    }

}
