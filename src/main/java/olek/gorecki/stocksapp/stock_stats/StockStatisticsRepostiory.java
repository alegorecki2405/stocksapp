package olek.gorecki.stocksapp.stock_stats;

import java.util.List;

public interface StockStatisticsRepostiory {
    List<StockStatistics> findStockStatisticsByStockId(Long Id);
    StockStatistics save(StockStatistics stockStatistics);
}
