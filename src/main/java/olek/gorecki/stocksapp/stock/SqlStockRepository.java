package olek.gorecki.stocksapp.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlStockRepository extends StockRepository, JpaRepository<Stock,Long> {
}
