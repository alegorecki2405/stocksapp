package olek.gorecki.stocksapp.user_stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlUserStatisticsRepository extends UserStatisticsRepository, JpaRepository<UserStatistics,Long> {
}
