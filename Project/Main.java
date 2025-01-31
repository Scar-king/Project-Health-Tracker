package Project;

import java.util.Scanner;

class HealthTracker {
    private String name;
    private int age;
    private char gender;
    private double weight, height;

    public HealthTracker(String name, int age, char gender, double weight, double height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your gender (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter your current weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your current height (m): ");
        double height = scanner.nextDouble();

        HealthTracker user = new HealthTracker(name, age, gender, weight, height);
        user.displayResult();

        scanner.close();
    }
}
