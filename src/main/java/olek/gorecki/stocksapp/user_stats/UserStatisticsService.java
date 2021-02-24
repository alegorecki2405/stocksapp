package olek.gorecki.stocksapp.user_stats;

import olek.gorecki.stocksapp.dates.DataRangeResolver;
import olek.gorecki.stocksapp.dates.DateRange;
import olek.gorecki.stocksapp.user.User;
import olek.gorecki.stocksapp.user.UserRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserStatisticsService {
    private final UserRepository userRepository;
    private final UserStatisticsRepository userStatisticsRepository;


    public UserStatisticsService(UserRepository userRepository, UserStatisticsRepository userStatisticsRepository) {
        this.userRepository = userRepository;
        this.userStatisticsRepository = userStatisticsRepository;
    }

    UserStatisticReadModel createUserStatistic(UserStatistics userStatistics, User user) {
        userStatistics.setUser(user);
        UserStatisticReadModel result = new UserStatisticReadModel(userStatisticsRepository.save(userStatistics));
        return result;
    }

    List<UserStatisticReadModel> findAllByUser(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        List<UserStatisticReadModel> result = new ArrayList<>();
        userStatisticsRepository.findAllByUser(user).forEach(userStatistics -> result.add(new UserStatisticReadModel(userStatistics)));
        return result;
    }

    List<UserStatisticReadModel> findAllByUserAndDate(Principal principal,
                                                      DateRange range,
                                                      @Nullable LocalDate start,
                                                      @Nullable LocalDate stop) {
        User user = userRepository.findByUsername(principal.getName());
        List<UserStatisticReadModel> result = new ArrayList<>();
        if (range.equals(DateRange.PICK)) {
            userStatisticsRepository.findAllByUserAndDateIsBetween(user, start, stop).forEach(userStatistics -> result.add(new UserStatisticReadModel(userStatistics)));
        } else {
            LocalDate startDate = DataRangeResolver.resolveStartDate(range);
            LocalDate endDate = DataRangeResolver.resolveEndDate(range);
            userStatisticsRepository.findAllByUserAndDateIsBetween(user, startDate, endDate).forEach(userStatistics -> result.add(new UserStatisticReadModel(userStatistics)));
        }
        return result;
    }
}
