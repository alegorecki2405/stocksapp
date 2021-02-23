package olek.gorecki.stocksapp.stock;

import olek.gorecki.stocksapp.user.User;
import olek.gorecki.stocksapp.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;
    private final UserRepository userRepository;

    public StockController(StockService stockService, UserRepository userRepository) {
        this.stockService = stockService;
        this.userRepository = userRepository;
    }

    //just for testing
    @PostMapping("/{id}")
    ResponseEntity<Object> createStock(@RequestBody @Valid Stock stock, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(errors);
        }
        Stock result = stockService.createStock(stock, id);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PostMapping
    ResponseEntity<Object> createStock(@RequestBody @Valid Stock stock, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Stock result = stockService.createStock(stock, user.getId());
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/{id}")
    ResponseEntity<StockReadModel> findById(@PathVariable Long id) {
        return stockService.findById(id)
                .map(body -> ResponseEntity.ok(new StockReadModel(body)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    ResponseEntity<List<StockReadModel>> findAllStocksByUser(Principal principal) {
        return ResponseEntity.ok(stockService.readAllStocksByUser(principal));
    }
}
