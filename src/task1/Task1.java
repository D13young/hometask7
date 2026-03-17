package task1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.function.BooleanSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class Task1 {
    public static void main(String[] args) {
        BooleanSupplier isLeapYear = () -> {
            int year = 2026;
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        };
        System.out.println("Год високосный? " + isLeapYear.getAsBoolean());

        LocalDate date1 = LocalDate.of(2025, 12, 31);
        LocalDate date2 = LocalDate.of(2026, 12, 31);
        LongSupplier daysBetween = () -> ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Количество дней между " + date1 + " и " + date2 + ": " + daysBetween.getAsLong());

        LongSupplier fullWeeksBetween = () -> daysBetween.getAsLong() / 7;
        System.out.println("Полных недель между " + date1 + " и " + date2 + ": " + fullWeeksBetween.getAsLong());

        LocalDate moonLanding = LocalDate.of(1969, 7, 20);
        Supplier<String> dayOfWeek = () -> moonLanding.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.forLanguageTag("ru"));
        System.out.println("20 июля 1969: " + dayOfWeek.get());
    }
}
