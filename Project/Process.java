package Project;

class Process extends HealthTracker {
    public Process(String name, int age, char gender, double weight, double height){
        super(name, age, gender, weight, height);
    }

    public double calculateBMI() {
        return weight / (Math.pow(height,2));
    }

    public double weightToReduce() {
        double bmi = calculateBMI();
        double TargetWeight = 24.9 * (Math.pow(height,2));
        return (bmi > 24.9) ? (weight - TargetWeight) : 0;
    }

    public void displayResult() {
        double bmi = calculateBMI();
        System.out.println("\nHealth Report for " + name + ":");
        System.out.printf("BMI: %.2f\n", bmi);
        System.out.printf("GENDER: %c\n", gender);
        System.out.printf("AGE: %d\n", age);
        if (bmi > 24.9) {
            System.out.printf("You should reduce %.2f kg to reach a healthy weight.\n", weightToReduce());
        } else {
            System.out.println("Your weight is within a healthy range!");
        }
    }
}
