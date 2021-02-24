package olek.gorecki.stocksapp.user_stats;

import olek.gorecki.stocksapp.user.User;

import java.time.LocalDate;
import java.util.List;

public interface UserStatisticsRepository {
    UserStatistics save(UserStatistics userStatistics);

    List<UserStatistics> findAllByUser(User user);

    List<UserStatistics> findAllByUserAndDateIsBetween(User user, LocalDate startDate, LocalDate stopDate);
}
