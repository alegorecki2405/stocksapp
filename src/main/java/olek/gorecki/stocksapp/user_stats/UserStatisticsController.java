package olek.gorecki.stocksapp.user_stats;

import olek.gorecki.stocksapp.dates.DateRange;
import olek.gorecki.stocksapp.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/userstatistics")
public class UserStatisticsController {
    private final UserStatisticsService userStatisticsService;

    public UserStatisticsController(UserStatisticsService userStatisticsService) {
        this.userStatisticsService = userStatisticsService;
    }

    @PostMapping
    ResponseEntity<Object> createUserStatistic(@RequestBody UserStatistics userStatistics, User user) {
        return ResponseEntity.ok(userStatisticsService.createUserStatistic(userStatistics, user));
    }

    @GetMapping
    ResponseEntity<List<UserStatisticReadModel>> findAllByUser(Principal principal) {
        return ResponseEntity.ok(userStatisticsService.findAllByUser(principal));
    }

    ResponseEntity<List<UserStatisticReadModel>> findAllByUserAndDate(Principal principal,
                                                                      @PathVariable DateRange range,
                                                                      @RequestParam @Nullable String start,
                                                                      @RequestParam @Nullable String end) {
        if (range.equals(DateRange.PICK)) {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);
            return ResponseEntity.ok(userStatisticsService.findAllByUserAndDate(principal, range, startDate, endDate));
        }
        return ResponseEntity.ok(userStatisticsService.findAllByUserAndDate(principal, range, null, null));
    }
}
