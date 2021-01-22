package olek.gorecki.stocksapp.stock_stats;

import java.time.LocalDate;
import java.util.List;

public interface StockStatisticsRepostiory {
    List<StockStatistics> findStockStatisticsByStockId(Long Id);

    StockStatistics save(StockStatistics stockStatistics);

    List<StockStatistics> findAllByDateIsBetweenAndStockId(LocalDate startDate, LocalDate stopDate, Long id);
}
