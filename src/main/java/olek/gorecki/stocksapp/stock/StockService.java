package olek.gorecki.stocksapp.stock;

import olek.gorecki.stocksapp.user.User;
import olek.gorecki.stocksapp.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final UserRepository userRepository;

    public StockService(StockRepository stockRepository, UserRepository userRepository) {
        this.stockRepository = stockRepository;
        this.userRepository = userRepository;
    }

    public Stock createStock(Stock stock, Long id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        stock.setUser(user);
        return stockRepository.save(stock);
    }

    public List<Stock> readAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    public List<Stock> readAllStocksByUser(User user) {
        return stockRepository.findAllByUser(user);
    }
}
