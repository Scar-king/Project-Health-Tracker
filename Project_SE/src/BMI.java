public class BMI extends Client {
    double weight, height;
    public BMI(String name, int age, String gender, double weight, double height) {
        super(name, age, gender);
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
        if(gender.equalsIgnoreCase("M")){
            System.out.println("\nHealth Report for Mr. " + Colors.GREEN + name + Colors.RESET + ":");
        } else {
            System.out.println("\nHealth Report for Ms. " + Colors.GREEN + name + Colors.RESET + ":");
        }
        System.out.printf("\nBMI: %.2f\n", bmi);
        System.out.printf("GENDER: %s\n", gender.toUpperCase());
        System.out.printf("AGE: %d\n\n", age);
        if (bmi > 24.9) {
            System.out.println(Colors.YELLOW + "You should reduce " + weightToReduce() + " kg to reach a healthy weight.\n"  + Colors.RESET);
        } else {
            System.out.println(Colors.GREEN + "Your weight is within a healthy range!\n" + Colors.RESET);
        }
    }
}
