package olek.gorecki.stocksapp.stock_stats;

import olek.gorecki.stocksapp.dates.DateRange;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/stockstatistics")
public class StockStatisticsController {

    private final StockStatisticsService stockStatisticsService;

    public StockStatisticsController(StockStatisticsService stockStatisticsService) {
        this.stockStatisticsService = stockStatisticsService;
    }

    //temp
    @PostMapping("/{id}")
    ResponseEntity<Object> createStatistic(@RequestBody StockStatistics stockStatistics, @PathVariable Long id) throws RuntimeException {
        return ResponseEntity.ok(stockStatisticsService.createStatistic(stockStatistics, id));
    }

    @GetMapping("/{id}")
    ResponseEntity<List<StockStatisticReadModel>> findAllById(@PathVariable Long id) {
        return ResponseEntity.ok(stockStatisticsService.findAllById(id));
    }

    @GetMapping("/{id}/{range}")
    ResponseEntity<List<StockStatistics>> findAllByIdAndDate(@PathVariable Long id,
                                                             @PathVariable DateRange range,
                                                             @RequestParam @Nullable String start,
                                                             @RequestParam @Nullable String end) {
        if (range.equals(DateRange.PICK)) {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);
            return ResponseEntity.ok(stockStatisticsService.findAllByIdAndDate(id, range, startDate, endDate));
        }
        return ResponseEntity.ok(stockStatisticsService.findAllByIdAndDate(id, range, null, null));
    }
}
