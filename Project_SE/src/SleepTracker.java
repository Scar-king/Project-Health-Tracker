import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SleepTracker extends Client {
    LocalTime sleepStart;
    LocalTime wakeUpTime;
    Duration timeInBedDuration;
    double timeInBed;
    int awakeMinutes;
    double totalSleepHours;
    double sleepEfficiency;
    List<SleepSession> sleepHistory;
    private Connection connection;
    public SleepTracker(String name, int age, String gender){
        super(name, age, gender);
        this.sleepStart = LocalTime.of(0,0);
        this.wakeUpTime = LocalTime.of(0,0);
        this.timeInBedDuration = Duration.ZERO;
        this.timeInBed = 0.0;
        this.awakeMinutes = 0;
        this.totalSleepHours = 0.0;
        this.sleepEfficiency = 0.0;
        this.sleepHistory = new ArrayList<>();
        connectionToDatabase();
    }

    public void inputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your sleep details in 24-hour format " + Colors.BRIGHT_RED + "(HH:mm)." + Colors.RESET);

        this.sleepStart = getValidTime(scanner, "Enter sleep start time " + Colors.BRIGHT_RED + "(e.g., 22:30 for 10:30 PM): " + Colors.RESET);
        this.wakeUpTime = getValidTime(scanner, "Enter wake-up time " + Colors.BRIGHT_RED + "(e.g., 06:30 for 6:30 AM): " + Colors.RESET);

        Duration timeInBedDuration = Duration.between(sleepStart, wakeUpTime);
        if (timeInBedDuration.isNegative()) {
            timeInBedDuration = timeInBedDuration.plusHours(24);
        }
        this.timeInBed = timeInBedDuration.toMinutes() / 60.0;
        long minutesBetween = timeInBedDuration.toMinutes();

        while (true) {
            System.out.print("How many minutes were you awake during the night?: ");
            if (scanner.hasNextInt()) {
                this.awakeMinutes = scanner.nextInt();
                if (this.awakeMinutes >= 0 && this.awakeMinutes <= minutesBetween) {
                    break; 
                } else {
                    System.out.println(Colors.RED + "Invalid input! Minutes awake cannot be negative or exceed the total time between sleep start and wake-up time. Please enter a valid number of minutes." + Colors.RESET);
                }
            } else {
                System.out.println(Colors.RED + "Invalid input! Please enter a valid number for minutes awake." + Colors.RESET);
                scanner.next();
            }
        }

        this.totalSleepHours = this.timeInBed - (this.awakeMinutes / 60.0);

        this.sleepEfficiency = (this.totalSleepHours / this.timeInBed) * 100;

        sleepHistory.add(new SleepSession(sleepStart, wakeUpTime, this.timeInBed, this.totalSleepHours, this.sleepEfficiency));

        saveDataToDatabase();
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

    private void connectionToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health_tracker",
                                                    "root", // Replace with your username
                                                    System.getenv("PASSWORD")); // Replace with your password
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    private void saveDataToDatabase(){
        String query = "INSERT INTO sleep_data (Name, Age, Gender, Sleep_Start, Wake_Up_Time, Time_In_Bed, Total_Sleep_Hours, Sleep_Efficiency, Date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            preparedStatement.setTime(4, java.sql.Time.valueOf(this.sleepStart));
            preparedStatement.setTime(5, java.sql.Time.valueOf(this.wakeUpTime));
            preparedStatement.setDouble(6, timeInBed);
            preparedStatement.setDouble(7, totalSleepHours);
            preparedStatement.setDouble(8, sleepEfficiency);
            preparedStatement.setTimestamp(9, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            preparedStatement.executeUpdate();
            System.out.println(Colors.GREEN+"Sleep Data saved successfully!"+Colors.RESET);
        } catch ( SQLException e) {
            System.out.println(Colors.RED+"Error saving Sleep Data: "+Colors.RESET + e.getMessage());
        }
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

        System.out.println("\nSleep History:");
        if(sleepHistory.isEmpty()) {
            System.out.println(Colors.BRIGHT_YELLOW+"No sleep data available."+Colors.RESET);
        } else {
            for(SleepSession session : sleepHistory) {
                System.out.println(session);
            }
        }
        System.out.println("====================================");
    }
}

class SleepSession {
    LocalTime sleepStart;
    LocalTime wakeUpTime;
    double timeInBed;
    double totalSleepHours;
    double sleepEfficiency;

    public SleepSession(LocalTime sleepStart, LocalTime wakeUpTime, double timeInBed, double totalSleepHours, double sleepEfficiency) {
        this.sleepStart = sleepStart;
        this.wakeUpTime = wakeUpTime;
        this.timeInBed = timeInBed;
        this.totalSleepHours = totalSleepHours;
        this.sleepEfficiency = sleepEfficiency;
    }

    @Override
    public String toString() {
        return String.format("Start Time: %s, Wake-Up Time: %s, Time in Bed: %.2f hours, Sleep Duration: %.2f hours, Sleep Efficiency: %.2f%%",
        sleepStart, wakeUpTime, timeInBed, totalSleepHours, sleepEfficiency);
    }
}
