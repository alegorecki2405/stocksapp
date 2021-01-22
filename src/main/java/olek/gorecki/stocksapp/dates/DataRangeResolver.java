package olek.gorecki.stocksapp.dates;

import java.time.LocalDate;

public class DataRangeResolver {
    public static LocalDate resolveStartDate(DateRange range) {
        LocalDate today = LocalDate.now();
        switch (range) {
            case DAY: {
                return today.minusDays(1);
            }
            case WEEK: {
                return today.minusDays(7);
            }
            case MONTH: {
                return today.minusDays(today.getDayOfMonth() - 1);
            }
            case YEAR: {
                int year = today.getYear();
                return LocalDate.of(year, 1, 1);
            }
        }
        return null;
    }

    public static LocalDate resolveEndDate(DateRange range) {
        return LocalDate.now();
    }
}
