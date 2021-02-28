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
    private UserStatisticsRepository userStatisticsRepository;


    public UserStatisticsResolver(UserRepository userRepository, StockRepository stockRepository, UserStatisticsService userStatisticsService, StockStatisticsRepostiory stockStatisticsRepostiory, UserStatisticsRepository userStatisticsRepository) {
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
        this.userStatisticsService = userStatisticsService;
        this.stockStatisticsRepostiory = stockStatisticsRepostiory;
        this.userStatisticsRepository = userStatisticsRepository;
    }

    @Scheduled(cron = "0 22 ? * MON-FRI")
    public void resolveDataforUser() {
        userRepository.findAll().forEach(user -> {
            resolve(user);
            updateUserMoney(user);
        });
    }

    public void updateUserMoney(User user) {
        UserStatistics userStatistics = userStatisticsRepository.findByUserAndDate(user, LocalDate.now()).orElseThrow(RuntimeException::new);
        float money = user.getMoney() + userStatistics.getMarketCloseMoneyValue();
        user.setMoney(money);
    }

    public void resolve(User user) {
        UserStatistics userStatistics = new UserStatistics();
        userStatistics.setDate(LocalDate.now());
        userStatistics.setMarketOpenMoneyValue(marketOpenSum(user));
        userStatistics.setMarketCloseMoneyValue(marketCloseSum(user));
        userStatistics.setPercentToday(percentToday(user));
        userStatisticsService.createUserStatistic(userStatistics, user);
    }

    public float marketOpenSum(User user) {
        double marketOpenMoneyValueProfit = stockRepository.findAllByUser(user).stream().mapToDouble(stock -> {
            StockStatistics stockStatistics = stockStatisticsRepostiory.findByStockAndDate(stock, LocalDate.now());
            return (double) (((stockStatistics.getOpenMarketPrice() / stock.getOpenPrice())
                    * stock.getMoneyValue() * stock.getLeverage()) - stock.getMoneyValue());
        }).sum();
        return (float) marketOpenMoneyValueProfit;
    }

    public float marketCloseSum(User user) {
        double marketCloseMoneyValueProfit = stockRepository.findAllByUser(user).stream().mapToDouble(stock -> {
            StockStatistics stockStatistics = stockStatisticsRepostiory.findByStockAndDate(stock, LocalDate.now());
            return (double) (((stockStatistics.getCloseMarketPrice() / stock.getOpenPrice())
                    * stock.getMoneyValue() * stock.getLeverage()) - stock.getMoneyValue());
        }).sum();
        return (float) marketCloseMoneyValueProfit;
    }

    public float percentToday(User user) {
        return marketCloseSum(user) / user.getMoney();
    }
}
