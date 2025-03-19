import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class HeartTracker extends Client {
    private int restingHR;
    private int maxHR;
    private int hrr;
    private int currentHR;
    private String heartZone;
    private Scanner scanner;
    private Connection connection;

    public HeartTracker(String name, int age, String gender) {
        super(name, age, gender);
        this.restingHR = 0;
        this.maxHR = 220 - age;
        this.hrr = 0;
        this.currentHR = 0;
        this.heartZone = "";
        this.scanner = new Scanner(System.in); 
        connectionToDatabase(); 
    }

    public void process() {

        while (true) {
            System.out.print("Enter your resting heart rate" + Colors.RED + " (Relax Heart Beat) " + Colors.RESET + "(BPM): ");
            if (scanner.hasNextInt()){
                this.restingHR = scanner.nextInt();
                if(restingHR >= 0){
                    break;
                } else {
                    System.out.println(Colors.RED + "Heart rate cannot be negative! Please enter a valid heart rate." + Colors.RESET);
                }
            } else {
                System.out.println(Colors.RED + "Invalid input! Please enter a valid number for resting heart rate." + Colors.RESET);
                scanner.next();
            }
        }

        System.out.println("\nHeart Rate Zones:");
        System.out.println(" Resting Zone (<50% of Max HR): < " + (int) (maxHR * 0.5) + " BPM");
        System.out.println(" Fat Burn Zone (50-70% of Max HR): " + (int) (maxHR * 0.5) + " - " + (int) (maxHR * 0.7) + " BPM");
        System.out.println(" Cardio Zone (70-85% of Max HR): " + (int) (maxHR * 0.7) + " - " + (int) (maxHR * 0.85) + " BPM");
        System.out.println(" Peak Zone (85-100% of Max HR): > " + (int) (maxHR * 0.85) + " BPM");

        while(true) {
            System.out.print("\nEnter your current heart rate (BPM): ");
            if(scanner.hasNextInt()){
                this.currentHR = scanner.nextInt();
                if(currentHR >= 0){
                    break;
                } else {
                    System.out.println(Colors.RED + "Heart rate cannot be negative! Please enter a valid current heart rate." + Colors.RESET);
                }
            } else {
                System.out.println(Colors.RED + "Invalid input! Please enter a valid number for current heart rate." + Colors.RESET);
                scanner.next();
            }
        }
        this.hrr = currentHR - restingHR;

        if (currentHR < maxHR * 0.5) {
            heartZone = "Resting Zone";
        } else if (currentHR < maxHR * 0.7) {
            heartZone = "Fat Burn Zone";
        } else if (currentHR < maxHR * 0.85) {
            heartZone = "Cardio Zone";
        } else {
            heartZone = "Peak Zone";
        }

        saveDataToDatabase();
    }

    private void connectionToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health_tracker", "root", System.getenv("PASSWORD"));
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    private void saveDataToDatabase() {
        String query = "INSERT INTO heart_rate_data (Name, Age, Gender, Resting_HR, Max_HR, HRR, Current_HR, Heart_Zone, Date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            preparedStatement.setInt(4, restingHR);
            preparedStatement.setInt(5, maxHR);
            preparedStatement.setInt(6, hrr);
            preparedStatement.setInt(7, currentHR);
            preparedStatement.setString(8, heartZone);
            preparedStatement.setTimestamp(9, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            preparedStatement.executeUpdate();
            System.out.println(Colors.GREEN + "Heart Data saved successfully!" + Colors.RESET);
        } catch (SQLException e) {
            System.out.println("Error saving Heart Data: " + e.getMessage());  
        }
    }

    @Override
    public void displayResult() {
        if(gender.equalsIgnoreCase("M")){
            System.out.println("\nHealth Report for Mr. " + Colors.GREEN + name + Colors.RESET + ":");
        } else {
            System.out.println("\nHealth Report for Ms. " + Colors.GREEN + name + Colors.RESET + ":");
        }

        System.out.println("\n===============================");
        System.out.println(" Max Heart Rate: " + maxHR + " BPM");
        System.out.println(" Your Current Heart Rate: " + currentHR + " BPM");
        System.out.println(" Your Heart Rate Reserve: " + hrr + " BPM");
        System.out.println(" Heart Rate Zone: " + heartZone);
        System.out.println("===============================");
    }
}
