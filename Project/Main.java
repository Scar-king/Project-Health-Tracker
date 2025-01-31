package Project;

import java.util.Scanner;

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

        Process process = new Process(name, age, gender, weight, height);
        process.displayResult();

        scanner.close();
    }
}
