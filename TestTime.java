import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class TestTime {
    public static void main(String[] args) {
        LocalTime start = LocalTime.of(6, 00); // 08:30 AM
        LocalTime end = LocalTime.of(23, 00);  // 12:15 PM

        Duration duration = Duration.between(start, end);
        System.out.println("Duration in minutes: " + duration.toHours());

        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);

        LocalTime time = LocalTime.of(8,30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formatTime = time.format(formatter);
        System.out.println("Formatted time: " + formatTime);
    }
}
