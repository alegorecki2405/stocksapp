package olek.gorecki.stocksapp.stock_stats;

import olek.gorecki.stocksapp.stock.Stock;

import java.time.LocalDate;
import java.util.List;

public interface StockStatisticsRepostiory {
    List<StockStatistics> findStockStatisticsByStockId(Long Id);

    StockStatistics save(StockStatistics stockStatistics);

    List<StockStatistics> findAllByDateIsBetweenAndStockId(LocalDate startDate, LocalDate stopDate, Long id);

    StockStatistics findByStockAndDate(Stock stock, LocalDate date);

}
