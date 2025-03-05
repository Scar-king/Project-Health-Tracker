package Project;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SleepTracker extends Client {
    LocalTime sleepStart;
    LocalTime wakeUpTime;
    Duration timeInBedDuration;
    double timeInBed;
    int awakeMinutes;
    double totalSleepHours;
    double sleepEfficiency;
    public SleepTracker(String name, int age, String gender){
        super(name, age, gender);
        this.sleepStart = LocalTime.of(0,0);
        this.wakeUpTime = LocalTime.of(0,0);
        this.timeInBedDuration = Duration.ZERO;;
        this.timeInBed = 0.0;
        this.awakeMinutes = 0;
        this.totalSleepHours = 0.0;
        this.sleepEfficiency = 0.0;
    }

    public void inputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Sleep Tracker!");
        System.out.println("Please enter your sleep details in 24-hour format " + Colors.BRIGHT_RED + "(HH:mm)." + Colors.RESET);
        LocalTime sleepStart = getValidTime(scanner, "Enter sleep start time " + Colors.BRIGHT_RED + "(e.g., 22:30 for 10:30 PM): " + Colors.RESET);
        LocalTime wakeUpTime = getValidTime(scanner, "Enter wake-up time " + Colors.BRIGHT_RED + "(e.g., 06:30 for 6:30 AM): " + Colors.RESET);

        Duration timeInBedDuration = Duration.between(sleepStart, wakeUpTime);
        if (timeInBedDuration.isNegative()) {
            timeInBedDuration = timeInBedDuration.plusHours(24);
        }
        this.timeInBed = timeInBedDuration.toMinutes() / 60.0;

        System.out.print("How many minutes were you awake during the night?: ");
        this.awakeMinutes = scanner.nextInt();

        this.totalSleepHours = this.timeInBed - (this.awakeMinutes / 60.0);

        this.sleepEfficiency = (this.totalSleepHours / this.timeInBed) * 100;
    }

    private static LocalTime getValidTime(Scanner scanner, String message) {
        LocalTime time = null;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        while (time == null) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                time = LocalTime.parse(input, timeFormatter);
            } catch (Exception e) {
                System.out.println("Invalid time format! Please enter time as HH:mm " + Colors.BRIGHT_RED + "(e.g., 23:00 for 11:00 PM)." + Colors.RESET);
            }
        }
        return time;
    }

    @Override
    public void displayResult() {
        if(gender.equalsIgnoreCase("M")){
            System.out.println("\nHealth Report for Mr. " + Colors.GREEN + name + Colors.RESET + ":");
        } else {
            System.out.println("\nHealth Report for Ms. " + Colors.GREEN + name + Colors.RESET + ":");
        }
        System.out.println("\n====================================");
        System.out.println("  Sleep Tracker Results");
        System.out.println("====================================");
        System.out.println(" Total Time in Bed: " + String.format("%.2f", timeInBed) + " hours");
        System.out.println(" Total Sleep Duration: " + String.format("%.2f", totalSleepHours) + " hours");
        System.out.println(" Sleep Efficiency: " + String.format("%.2f", sleepEfficiency) + "%");

        System.out.print(" Sleep Quality: ");
        if (sleepEfficiency > 90) {
            System.out.println(Colors.BRIGHT_GREEN + "Excellent! Keep it up!" + Colors.RESET);
        } else if (sleepEfficiency >= 85) {
            System.out.println(Colors.BRIGHT_GREEN + "Good sleep quality!" + Colors.RESET);
        } else if (sleepEfficiency >= 75) {
            System.out.println(Colors.BRIGHT_GREEN + "Fair, but can improve." + Colors.RESET);
        } else {
            System.out.println(Colors.BRIGHT_RED + "Poor sleep. Try improving sleep habits!" + Colors.RESET);
        }
        System.out.println("====================================");
    }
}
