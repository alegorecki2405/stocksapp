package olek.gorecki.stocksapp.stock;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @PostMapping
    ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock result = stockRepository.save(stock);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

    @GetMapping
    ResponseEntity<List<Stock>> readAllStocks() {
        return ResponseEntity.ok(stockRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Stock> findById(@PathVariable Long id) {
        return stockRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
