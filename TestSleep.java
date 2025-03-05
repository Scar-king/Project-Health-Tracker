import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestSleep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Sleep Tracker!");
        System.out.println("Please enter your sleep details in 24-hour format (HH:mm).");

        // Get sleep start time
        LocalTime sleepStart = getValidTime(scanner, " Enter sleep start time (e.g., 22:30 for 10:30 PM): ");

        // Get wake-up time
        LocalTime wakeUpTime = getValidTime(scanner, " Enter wake-up time (e.g., 06:30 for 6:30 AM): ");

        // Calculate total time in bed
        Duration timeInBedDuration = Duration.between(sleepStart, wakeUpTime);
        if (timeInBedDuration.isNegative()) {
            timeInBedDuration = timeInBedDuration.plusHours(24); // Handles sleep across midnight
        }
        double timeInBed = timeInBedDuration.toMinutes() / 60.0;

        // Ask user about sleep interruptions
        System.out.print("How many minutes were you awake during the night?: ");
        int awakeMinutes = scanner.nextInt();

        // Calculate actual sleep duration
        double totalSleepHours = timeInBed - (awakeMinutes / 60.0);

        // Calculate sleep efficiency
        double sleepEfficiency = (totalSleepHours / timeInBed) * 100;

        // Display results
        System.out.println("\n====================================");
        System.out.println("  Sleep Tracker Results");
        System.out.println("====================================");
        System.out.println(" Total Time in Bed: " + String.format("%.2f", timeInBed) + " hours");
        System.out.println(" Total Sleep Duration: " + String.format("%.2f", totalSleepHours) + " hours");
        System.out.println(" Sleep Efficiency: " + String.format("%.2f", sleepEfficiency) + "%");

        // Sleep efficiency rating
        System.out.print("Sleep Quality: ");
        if (sleepEfficiency > 90) {
            System.out.println("Excellent! Keep it up! ");
        } else if (sleepEfficiency >= 85) {
            System.out.println("Good sleep quality! ");
        } else if (sleepEfficiency >= 75) {
            System.out.println("Fair, but can improve.");
        } else {
            System.out.println("Poor sleep. Try improving sleep habits! ");
        }

        System.out.println("====================================");

        scanner.close();
    }

    // Method to get a valid time input from user
    private static LocalTime getValidTime(Scanner scanner, String message) {
        LocalTime time = null;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        while (time == null) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                time = LocalTime.parse(input, timeFormatter);
            } catch (Exception e) {
                System.out.println("Invalid time format! Please enter time as HH:mm (e.g., 23:00 for 11:00 PM).");
            }
        }
        return time;
    }
}
