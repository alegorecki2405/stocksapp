package olek.gorecki.stocksapp.stock_stats;

import olek.gorecki.stocksapp.dates.DateRange;
import olek.gorecki.stocksapp.stock.Stock;
import olek.gorecki.stocksapp.stock.StockRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class StockStatisticsService {

    private final StockStatisticsRepostiory stockStatisticsRepostiory;
    private final StockRepository stockRepository;

    public StockStatisticsService(StockStatisticsRepostiory stockStatisticsRepostiory, StockRepository stockRepository) {
        this.stockStatisticsRepostiory = stockStatisticsRepostiory;
        this.stockRepository = stockRepository;
    }

    public StockStatistics createStatistic(StockStatistics stockStatistics, Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(RuntimeException::new);
        stockStatistics.setStock(stock);
        return stockStatisticsRepostiory.save(stockStatistics);
    }

    public List<StockStatistics> findAllById(Long id) {
        return stockStatisticsRepostiory.findStockStatisticsByStockId(id);
    }

    public List<StockStatistics> findAllByIdAndDate(Long id, DateRange range, @Nullable LocalTime start,@Nullable LocalTime stop) {
        return null;
    }
}
