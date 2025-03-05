import java.util.Scanner;

public class TestWater {

    // WaterIntake class to track total intake and hydration level
    static class WaterIntake {
        private double totalWaterIntake;  // in liters
        private double goalWaterIntake;   // in liters
        private String hydrationLevel;    // Hydration status: "Hydrated" or "Dehydrated"

        // Constructor
        public WaterIntake(double goalWaterIntake) {
            this.goalWaterIntake = goalWaterIntake;
            this.totalWaterIntake = 0.0;  // Initial total intake is 0
            this.hydrationLevel = "Not tracked yet";
        }

        // Method to log water intake
        public void logWaterIntake(double waterAmount) {
            this.totalWaterIntake += waterAmount;
            updateHydrationLevel();  // Update hydration status based on intake
        }

        // Method to calculate hydration level
        private void updateHydrationLevel() {
            if (totalWaterIntake >= goalWaterIntake) {
                this.hydrationLevel = "Hydrated";
            } else {
                this.hydrationLevel = "Dehydrated";
            }
        }

        // Method to get the progress of water intake as a percentage
        public double getIntakeProgress() {
            double progress = (totalWaterIntake / goalWaterIntake) * 100;
            // Ensure the progress doesn't exceed 100%
            if (progress > 100) {
                progress = 100;
            }
            return progress;
        }

        // Method to display current water intake info

        public void displayResult(){
            System.out.println("Total Water Intake: " + totalWaterIntake + " L ");
            System.out.println("Goal: " +  goalWaterIntake + " L ");
            System.out.println("Hydration Level: " + hydrationLevel);
        }
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for their daily water intake goal
        System.out.println("Enter your daily water intake goal (in liters): ");
        double goal = scanner.nextDouble();

        // Create a WaterIntake object with the user's goal
        WaterIntake waterTracker = new WaterIntake(goal);

        // Allow the user to input water intake multiple times throughout the day
        String userChoice = "yes"; // Initial choice to start the loop
        while (userChoice.equalsIgnoreCase("yes") && waterTracker.getIntakeProgress() < 100) {
            System.out.println("\nEnter the amount of water you drank (in liters): ");
            double waterAmount = scanner.nextDouble();

            // Log the user's water intake
            waterTracker.logWaterIntake(waterAmount);

            // Show the current water intake and hydration status
            waterTracker.displayResult();
            System.out.println("Intake Progress: " + waterTracker.getIntakeProgress() + "%");

            // Ask the user if they want to continue logging water intake only if progress is less than 100%
            if (waterTracker.getIntakeProgress() < 100) {
                System.out.println("\nDo you want to log more water intake? (yes/no)");
                userChoice = scanner.next();
            }
        }

        System.out.println("Thank You!");

        scanner.close();
    }
}
