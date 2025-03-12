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
            PreparedStatement statement = connection.prepareStatement(query)){
            
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setDouble(4, totalWaterIntake);
            statement.setDouble(5, goalWaterIntake);
            statement.setString(6, hydrationLevel);
            statement.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            statement.executeUpdate();
            System.out.println(Colors.GREEN + "Water Tracker Data saved successfully!" + Colors.RESET);
        } catch (SQLException e) {
            System.out.println(Colors.RED + "Error saving water tracker data: " + e.getMessage() + Colors.RESET);
        }
    }

    public void logWaterIntake(double waterAmount){
        this.totalWaterIntake += waterAmount;
        dailyIntakes.add(waterAmount);
        updateHydrationLevel();
        saveDataToDatabase();
        // if (getIntakeProgress() == 100) {
        //     System.out.println(Colors.BRIGHT_GREEN + "Congratulations! You've reached your water intake goal for the day!" + Colors.RESET);
        // }
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
    if (getIntakeProgress() == 100) {
        System.out.println(Colors.BRIGHT_GREEN + "\nCongratulations! You've reached your water intake goal for the day!" + Colors.RESET);
    }
}

}

