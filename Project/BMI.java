package Project;

public class BMI extends Client {
    private double weight, height;

    public BMI(String name, int age, String gender, double weight, double height, double heartRate, double caloriesBurned, double waterIntake, double sleepHours, String bloodPressure, double bloodSugar) {
        super(name, age, gender, heartRate, caloriesBurned, waterIntake, sleepHours, bloodPressure, bloodSugar);
        this.weight = weight;
        this.height = height;
    }

    public double calculateBMI() {
        return weight / (Math.pow(height, 2));
    }

    public double weightToReduce() {
        double bmi = calculateBMI();
        double targetWeight = 24.9 * (Math.pow(height, 2));
        return (bmi > 24.9) ? (weight - targetWeight) : 0;
    }

    @Override
    public void displayResult() {
        double bmi = calculateBMI();
        System.out.println("\nHealth Report for " + (gender.equalsIgnoreCase("M") ? "Mr." : "Ms.") + name + ":");
        System.out.printf("BMI: %.2f\n", bmi);
        System.out.printf("Heart Rate: %.1f bpm\n", heartRate);
        System.out.printf("Calories Burned: %.1f kcal\n", caloriesBurned);
        System.out.printf("Water Intake: %.1f L\n", waterIntake);
        System.out.printf("Sleep Hours: %.1f hrs\n", sleepHours);
        System.out.printf("Blood Pressure: %s\n", bloodPressure);
        System.out.printf("Blood Sugar: %.1f mg/dL\n", bloodSugar);
        if (bmi > 24.9) {
            System.out.printf("You should reduce %.2f kg to reach a healthy weight.\n", weightToReduce());
        } else {
            System.out.println("Your weight is within a healthy range!");
        }
        
    }
}