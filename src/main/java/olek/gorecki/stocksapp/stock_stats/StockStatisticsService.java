package olek.gorecki.stocksapp.stock_stats;

import olek.gorecki.stocksapp.dates.DataRangeResolver;
import olek.gorecki.stocksapp.dates.DateRange;
import olek.gorecki.stocksapp.stock.Stock;
import olek.gorecki.stocksapp.stock.StockRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockStatisticsService {

    private final StockStatisticsRepostiory stockStatisticsRepostiory;
    private final StockRepository stockRepository;

    public StockStatisticsService(StockStatisticsRepostiory stockStatisticsRepostiory, StockRepository stockRepository) {
        this.stockStatisticsRepostiory = stockStatisticsRepostiory;
        this.stockRepository = stockRepository;
    }

    public StockStatisticReadModel createStatistic(StockStatistics stockStatistics, Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(RuntimeException::new);
        stockStatistics.setStock(stock);
        StockStatisticReadModel result = new StockStatisticReadModel(stockStatisticsRepostiory.save(stockStatistics));
        return result;
    }

    public List<StockStatisticReadModel> findAllById(Long id) {
        List<StockStatisticReadModel> result = new ArrayList<>();
        stockStatisticsRepostiory.findStockStatisticsByStockId(id).forEach(
                stockStatistics -> result.add(new StockStatisticReadModel(stockStatistics))
        );
        return result;
    }

    public List<StockStatistics> findAllByIdAndDate(Long id, DateRange range, @Nullable LocalDate start, @Nullable LocalDate stop) {
        if (range.equals(DateRange.PICK)) {
            return stockStatisticsRepostiory.findAllByDateIsBetweenAndStockId(start, stop, id);
        } else {
            LocalDate startDate = DataRangeResolver.resolveStartDate(range);
            LocalDate endDate = DataRangeResolver.resolveEndDate(range);
            return stockStatisticsRepostiory.findAllByDateIsBetweenAndStockId(startDate, endDate, id);
        }
    }
}
