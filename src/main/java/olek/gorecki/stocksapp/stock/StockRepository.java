package olek.gorecki.stocksapp.stock;

import java.util.List;
import java.util.Optional;

public interface StockRepository {
    Stock save(Stock stock);
    List<Stock> findAll();
    Optional<Stock> findById(Long Id);
}
