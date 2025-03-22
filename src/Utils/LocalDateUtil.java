package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateUtil {

    // Method to extract the year from a LocalDate
    public static int getYear(LocalDate date) {
        return date.getYear();
    }

    // Method to extract the month from a LocalDate
    public static int getMonth(LocalDate date) {
        return date.getMonthValue();
    }

    // Method to extract the day of the month from a LocalDate
    public static int getDay(LocalDate date) {
        return date.getDayOfMonth();
    }

    // Method to add a year to a LocalDate
    public static LocalDate addYears(LocalDate date, int years) {
        return date.plusYears(years);
    }

    // Method to add a month to a LocalDate
    public static LocalDate addMonths(LocalDate date, int months) {
        return date.plusMonths(months);
    }

    // Method to add days to a LocalDate
    public static LocalDate addDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    // Method to subtract a year from a LocalDate
    public static LocalDate subtractYears(LocalDate date, int years) {
        return date.minusYears(years);
    }

    // Method to subtract a month from a LocalDate
    public static LocalDate subtractMonths(LocalDate date, int months) {
        return date.minusMonths(months);
    }

    // Method to subtract days from a LocalDate
    public static LocalDate subtractDays(LocalDate date, int days) {
        return date.minusDays(days);
    }

    // Method to convert LocalDate to string based on input format
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    // Method to parse a string to LocalDate based on input format
    public static LocalDate parseDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }

    public static void main(String[] args) {
        // Example usage
        LocalDate today = LocalDate.now();

        System.out.println("Today: " + today);
        System.out.println("Year: " + getYear(today));
        System.out.println("Month: " + getMonth(today));
        System.out.println("Day: " + getDay(today));

        LocalDate nextMonth = addMonths(today, 1);
        System.out.println("Next Month: " + nextMonth);

        LocalDate lastYear = subtractYears(today, 1);
        System.out.println("Last Year: " + lastYear);

        String formattedDate = formatDate(today, "dd-MM-yyyy");
        System.out.println("Formatted Date: " + formattedDate);

        LocalDate parsedDate = parseDate("15-05-2024", "dd-MM-yyyy");
        System.out.println("Parsed Date:     " + parsedDate);

        String jpql = "@Query( \"select asetIdNbr, fprsNetBalDate, fprsNetBalA, borI," +
                " borBnkRoutC, updDate from AsetFprsNetBalEntity " +
                "where fprsNetBalDate = :fprsNetBalDate\" )";
    }
}
