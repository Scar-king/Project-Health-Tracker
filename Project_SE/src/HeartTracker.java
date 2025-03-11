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

    public HeartTracker(String name, int age, String gender) {
        super(name, age, gender);
        this.restingHR = 0;
        this.maxHR = 220 - age;
        this.hrr = 0;
        this.currentHR = 0;
        this.heartZone = "";
        this.scanner = new Scanner(System.in);  
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

    private void saveDataToDatabase() {
        String query = "INSERT INTO heart_rate_data (Name, Age, Gender, Resting_HR, Max_HR, HRR, Current_HR, Heart_Zone, Date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health_tracker", "root", System.getenv("PASSWORD"));
            PreparedStatement stmt = connection.prepareStatement(query)) {
            
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setInt(4, restingHR);
            stmt.setInt(5, maxHR);
            stmt.setInt(6, hrr);
            stmt.setInt(7, currentHR);
            stmt.setString(8, heartZone);
            stmt.setTimestamp(9, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            stmt.executeUpdate();
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

    public int getRestingHR() { return restingHR; }
    public int getMaxHR() { return maxHR; }
    public int getHrr() { return hrr; }
    public int getCurrentHR() { return currentHR; }
}
