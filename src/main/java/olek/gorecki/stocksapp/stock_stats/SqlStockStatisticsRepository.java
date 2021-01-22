package olek.gorecki.stocksapp.stock_stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SqlStockStatisticsRepository extends StockStatisticsRepostiory, JpaRepository<StockStatistics,Long> {
}
