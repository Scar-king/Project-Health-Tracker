import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaterTracker extends Client {
    double totalWaterIntake;
    double goalWaterIntake;
    String hydrationLevel;
    List<Double> dailyIntakes;
    private Connection connection;

    public WaterTracker(double goalWaterIntake, String name, int age, String gender){
        super(name, age, gender);
        this.goalWaterIntake = goalWaterIntake;
        this.totalWaterIntake = 0.0;
        this.hydrationLevel = "Not tracked yet";
        this.dailyIntakes = new ArrayList<>();
        connectionToDatabase();
    }

    private void connectionToDatabase(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health_tracker",
                                                    "root", // Replace with your username
                                                    System.getenv("PASSWORD")); // Replace with your password
        } catch (SQLException e) {
            System.out.println(Colors.RED + "Database connection error: " + e.getMessage() + Colors.RESET);
        }
    }

    private void saveDataToDatabase(){
        String query = "INSERT INTO water_data (Name, Age, Gender, Total_Water_Intake, Goal_Water_Intake, Hydration_Level, Date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            preparedStatement.setDouble(4, totalWaterIntake);
            preparedStatement.setDouble(5, goalWaterIntake);
            preparedStatement.setString(6, hydrationLevel);
            preparedStatement.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            System.out.println(Colors.GREEN + "Water Tracker Data saved successfully!" + Colors.RESET);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(Colors.RED + "Error saving water tracker data: " + e.getMessage() + Colors.RESET);
        }
    }

    public void logWaterIntake(double waterAmount){
        this.totalWaterIntake += waterAmount;
        dailyIntakes.add(waterAmount);
        updateHydrationLevel();
        saveDataToDatabase();
    }
    

    private void updateHydrationLevel() {
        if(totalWaterIntake >= goalWaterIntake * 1.5) {
            this.hydrationLevel = "Over-hydrated";
        } else if (totalWaterIntake >= goalWaterIntake) {
            this.hydrationLevel = "Hydrated";
        } else {
            this.hydrationLevel = "Dehydrated";
        }
    }

    public double getIntakeProgress() {
        double progress = (totalWaterIntake / goalWaterIntake) * 100;
        if(progress > 100){
            progress = 100;
        }
        return progress;
    }

    @Override
    public void displayResult() {
        if(gender.equalsIgnoreCase("M")){
            System.out.println("\nHealth Report for Mr. " + Colors.GREEN + name + Colors.RESET + ":");
        } else {
            System.out.println("\nHealth Report for Ms. " + Colors.GREEN + name + Colors.RESET + ":");
        }
        System.out.println("Total Water Intake: " + totalWaterIntake + " L ");
        System.out.println("Goal: " + goalWaterIntake + " L ");
        System.out.println("Hydration Level: " + hydrationLevel);

        System.out.println("\nWater Intake History:");
        if (dailyIntakes.isEmpty()) {
            System.out.println(Colors.BRIGHT_YELLOW + "No logs available yet." + Colors.RESET);
        } else {
            for(int i = 0; i < dailyIntakes.size(); i++){
                System.out.printf(Colors.BRIGHT_PURPLE + "The Number of Intake %d: %.2f L\n" + Colors.RESET, i + 1, dailyIntakes.get(i));
            }
        }
    }
}

