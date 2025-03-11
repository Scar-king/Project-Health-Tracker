import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class stepTracker extends Client {
    int stepCount;
    int stepGoal;
    double weight;
    private Connection connection;
    stepTracker(String name, int age, String gender, int stepCount, int stepGoal, double weight){
        super(name, age, gender);
        this.stepCount = stepCount;
        this.stepGoal = stepGoal;
        this.weight = weight;
        connectionToDatabase();
    }

    private void connectionToDatabase(){
        try {
            String url = "jdbc:mysql://localhost:3306/health_tracker";
            String username = "root";
            String password = System.getenv("PASSWORD");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    public void saveDataToDatabase() {
        String query = "INSERT INTO step_data (Name, Age, Gender, Steps_Count, Step_Goal, Weight, Date) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setInt(4, stepCount);
            stmt.setInt(5, stepGoal);
            stmt.setDouble(6, weight);
            stmt.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

            System.out.println(Colors.GREEN+"Step Tracker data saved to database successfully!"+Colors.RESET);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(Colors.RED+"Error saving data: "+Colors.RESET + e.getMessage());
        }
    }

    int remainingSteps(){
        return stepGoal - stepCount;
    }

    double caloriesBurned(){
        return ((double)stepCount / 2000) * weight;
    }

    @Override
    public void displayResult() {
        if(gender.equalsIgnoreCase("M")){
            System.out.println("\nHealth Report for Mr. " + Colors.GREEN + name + Colors.RESET + ":");
        } else {
            System.out.println("\nHealth Report for Ms. " + Colors.GREEN + name + Colors.RESET + ":");
        }
        System.out.printf("\nTotal steps today: " + Colors.BRIGHT_BLUE + "%d" + Colors.RESET + " step\n", stepCount);
        System.out.printf("Your step goal: " + Colors.BRIGHT_GREEN + "%d" + Colors.RESET + " steps\n", stepGoal);
        if(stepCount < stepGoal){
            System.out.printf("You need " + Colors.BRIGHT_RED + "%d" + Colors.RESET + " more steps to reach your goal!\n", remainingSteps());
        } else {
            System.out.println(Colors.BRIGHT_YELLOW + "Great job! You have met your step goal for today." + Colors.RESET);
            System.out.println(Colors.BRIGHT_YELLOW + "Amazing! You walked beyond your goal! Keep it up!" + Colors.RESET);
        }

        System.out.printf(Colors.BRIGHT_YELLOW + "Calories burned today: " + Colors.BRIGHT_GREEN + "%.2f" + Colors.RESET + " calories\n", caloriesBurned());
        System.out.println(Colors.BRIGHT_GREEN + "\nRemember: Keep moving! Stay active to improve your overall health." + Colors.RESET);

        saveDataToDatabase();
    }
}
