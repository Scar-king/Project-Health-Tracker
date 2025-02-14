package Project;

public class stepTracker extends Client {
    int stepCount;
    int stepGoal;
    double weight;
    // int heartRate;
    // double caloriesBurned;
    // double waterIntake;
    // double sleepHours;
    // String bloodPressure;
    // double bloodSugar;

    stepTracker(String name, int age, String gender, int stepCount, int stepGoal, double weight, int heartRate, double caloriesBurned, double waterIntake, double sleepHours, String bloodPressure, double bloodSugar) {
        super(name, age, gender , heartRate, caloriesBurned, waterIntake, sleepHours, bloodPressure, bloodSugar);
        this.stepCount = stepCount;
        this.stepGoal = stepGoal;
        this.weight = weight;
        this.heartRate = heartRate;
        this.caloriesBurned = caloriesBurned;
        this.waterIntake = waterIntake;
        this.sleepHours = sleepHours;
        this.bloodPressure = bloodPressure;
        this.bloodSugar = bloodSugar;
    }

    int remainingSteps() {
        return stepGoal - stepCount;
    }

    double calculateCaloriesBurned() {
        return ((double) stepCount / 2000) * weight;
    }

    @Override
    public void displayResult() {
        if (gender.equalsIgnoreCase("M")) {
            System.out.println("\nHealth Report for Mr." + name + ":");
        } else {
            System.out.println("\nHealth Report for Ms." + name + ":");
        }
        System.out.printf("Total steps today: %d steps\n", stepCount);
        System.out.printf("Your step goal: %d steps\n", stepGoal);
        if (stepCount < stepGoal) {
            System.out.printf("You need %d more steps to reach your goal!\n", remainingSteps());
        } else {
            System.out.println("Well done!");
        }
        if (stepCount >= stepGoal) {
            System.out.println("Great job! You've met your step goal for today.");
        } else {
            System.out.println("You're doing well! Keep walking to reach your goal.");
        }
        System.out.printf("Calories burned today: %.2f calories\n", calculateCaloriesBurned());
        System.out.printf("Heart Rate: %d bpm\n", heartRate);
        System.out.printf("Water Intake: %.2f liters\n", waterIntake);
        System.out.printf("Sleep Hours: %.2f hours\n", sleepHours);
        System.out.printf("Blood Pressure: %s mmHg\n", bloodPressure);
        System.out.printf("Blood Sugar Level: %.2f mg/dL\n", bloodSugar);
        System.out.println("Remember: Keep moving! Stay active to improve your overall health.");
    }
}
