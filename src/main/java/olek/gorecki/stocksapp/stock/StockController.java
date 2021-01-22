package olek.gorecki.stocksapp.stock;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    ResponseEntity<Object> createStock(@RequestBody @Valid Stock stock, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream().map(e->e.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(errors);
        }
        Stock result = stockService.createStock(stock);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

    @GetMapping
    ResponseEntity<List<Stock>> readAllStocks() {
        return ResponseEntity.ok(stockService.readAllStocks());
    }

    @GetMapping("/{id}")
    ResponseEntity<Stock> findById(@PathVariable Long id) {
        return stockService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
