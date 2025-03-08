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

    public WaterTracker(double goalWaterIntake, String name, int age, String gender){
        super(name, age, gender);
        this.goalWaterIntake = goalWaterIntake;
        this.totalWaterIntake = 0.0;
        this.hydrationLevel = "Not tracked yet";
        this.dailyIntakes = new ArrayList<>();
    }

    private void saveDataToDatabase(){
        String query = "INSERT INTO water_data (Name, Age, Gender, Total_Water_Intake, Goal_Water_Intake, Hydration_Level, Date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health_tracker", "root", System.getenv("PASSWORD"));
            PreparedStatement stmt = connection.prepareStatement(query)){
            
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setDouble(4, totalWaterIntake);
            stmt.setDouble(5, goalWaterIntake);
            stmt.setString(6, hydrationLevel);
            stmt.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            stmt.executeUpdate();
            System.out.println("Water Tracker Data saved successfully!");
        } catch (SQLException e) {
           System.out.println("Error saving water tracker data: " + e.getMessage());
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
            System.out.println("No logs available yet.");
        } else {
            for(int i = 0; i < dailyIntakes.size(); i++){
                System.out.printf("Day %d: %.2f L\n", i + 1, dailyIntakes.get(i));
            }
        }
    }
}

