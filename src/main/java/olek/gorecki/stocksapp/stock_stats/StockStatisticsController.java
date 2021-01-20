package olek.gorecki.stocksapp.stock_stats;

import olek.gorecki.stocksapp.dates.DateRange;
import olek.gorecki.stocksapp.stock.Stock;
import olek.gorecki.stocksapp.stock.StockRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockstatistics")
public class StockStatisticsController {

    private final StockStatisticsRepostiory stockStatisticsRepostiory;
    private final StockRepository stockRepository;

    public StockStatisticsController(StockStatisticsRepostiory stockStatisticsRepostiory, StockRepository stockRepository) {
        this.stockStatisticsRepostiory = stockStatisticsRepostiory;
        this.stockRepository = stockRepository;
    }

    //temp
    @PostMapping("/{id}")
    ResponseEntity<Object> createStat(@RequestBody StockStatistics stockStatistics, @PathVariable Long id) throws RuntimeException {
        Stock stock = stockRepository.findById(id).orElseThrow(RuntimeException::new);
        stock.getStockStatistics().add(stockStatistics);
        stockRepository.save(stock);
        return ResponseEntity.ok(stockStatistics);
    }

    @GetMapping("/{id}")
    ResponseEntity<List<StockStatistics>> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(stockStatisticsRepostiory.findStockStatisticsByStockId(id));
    }

    @GetMapping("/{id}/{range}")
    ResponseEntity<List<StockStatistics>> findAllByIdAndDate(@PathVariable Long id
            , @PathVariable DateRange range) {
        return null;
    }

}
