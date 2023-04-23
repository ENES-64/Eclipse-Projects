package horoscope;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Horoscope {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birth date:");
        String input = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthDate = LocalDate.parse(input, formatter);
        String zodiacSign = getZodiacSign(birthDate);

        System.out.println("Your zodiac sign is: " + zodiacSign);
    }

    private static String getZodiacSign(LocalDate birthDate) {
        MonthDay birthMonthDay = MonthDay.from(birthDate);

        if (isBetween(birthMonthDay, MonthDay.of(3, 21), MonthDay.of(4, 19))) {
            return "Aries";
        } else if (isBetween(birthMonthDay, MonthDay.of(4, 20), MonthDay.of(5, 20))) {
            return "Taurus";
        } else if (isBetween(birthMonthDay, MonthDay.of(5, 21), MonthDay.of(6, 20))) {
            return "Gemini";
        } else if (isBetween(birthMonthDay, MonthDay.of(6, 21), MonthDay.of(7, 22))) {
            return "Cancer";
        } else if (isBetween(birthMonthDay, MonthDay.of(7, 23), MonthDay.of(8, 22))) {
            return "Leo";
        } else if (isBetween(birthMonthDay, MonthDay.of(8, 23), MonthDay.of(9, 22))) {
            return "Virgo";
        } else if (isBetween(birthMonthDay, MonthDay.of(9, 23), MonthDay.of(10, 22))) {
            return "Libra";
        } else if (isBetween(birthMonthDay, MonthDay.of(10, 23), MonthDay.of(11, 21))) {
            return "Scorpio";
        } else if (isBetween(birthMonthDay, MonthDay.of(11, 22), MonthDay.of(12, 21))) {
            return "Sagittarius";
        } else if (isBetween(birthMonthDay, MonthDay.of(12, 22), MonthDay.of(1, 19))) {
            return "Capricorn";
        } else if (isBetween(birthMonthDay, MonthDay.of(1, 20), MonthDay.of(2, 18))) {
            return "Aquarius";
        } else {
            return "Pisces";
        }
    }

    private static boolean isBetween(MonthDay target, MonthDay start, MonthDay end) {
        if (start.compareTo(end) <= 0) {
            return target.compareTo(start) >= 0 && target.compareTo(end) <= 0;
        } else {
            return target.compareTo(start) >= 0 || target.compareTo(end) <= 0;
        }
    }
}