import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        Time t = new Time();
        t.hour = 12;
        t.minute = 0;
        t.second = 0;
        return t;
    }

    public static Time midnight() {
        Time t = new Time();
        t.hour = 0;
        t.minute = 0;
        t.second = 0;
        return t;
    }

    public static Time ofSeconds(long seconds) {
        Time t = new Time();
        long secondOffDay = seconds - (seconds / (60 * 60 *24)) * (60 * 60 *24);
        t.hour = (int) (secondOffDay / (60 * 60));
        t.minute = (int) (secondOffDay - t.hour * 60 * 60) / 60;
        t.second = (int) (secondOffDay - t.hour * 60 * 60 - t.minute * 60);
        return t;
    }

    public static Time of(int hour, int minute, int second) {
        if (hour < 24 && hour >= 0 && minute >= 0 && minute < 60 && second < 60 && second >= 0) {
            Time t = new Time();
            t.hour = hour;
            t.minute = minute;
            t.second = second;
            return t;
        } else return null;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}