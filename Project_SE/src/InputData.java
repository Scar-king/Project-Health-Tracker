import java.sql.*;
import java.util.Scanner;

public class InputData {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/health_tracker";
        String user = "root";
        String password = System.getenv("PASSWORD");
        return DriverManager.getConnection(url, user, password);
    }

    public static void clear() {
        try {
            System.out.println("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            System.out.println("Error clearing screen");
        }
    }

    void InputValue() {
        Scanner scanner = new Scanner(System.in);

        // Name Input
        String name;
        while (true) {
            System.out.print("Enter your Name: ");
            name = scanner.nextLine().trim();

            if (name.matches("^[A-Za-z\\s]+$")) {
                break;
            } else {
                System.out.println(Colors.RED + "Invalid name! Please enter only letters and spaces." + Colors.RESET);
            }
        }

        // Age Input
        int age = -1;
        while (true) {
            System.out.print("Enter your Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine();
                if (age >= 0 && age <= 100) {
                    break;
                } else {
                    System.out.println("Invalid input! Age must be between 0 and 100");
                }
            } else {
                System.out.println("Invalid input! Please enter a number only!");
                scanner.nextLine();
            }
        }

        // Gender Input
        String gender;
        while (true) {
            System.out.print("Enter your Gender (M/F): ");
            gender = scanner.nextLine().trim().toUpperCase();
            if (gender.equals("M") || gender.equals("F")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter 'M' or 'F'");
            }
        }

        clear();
        Menu menu = new Menu();

        int choice;
        while (true) {
            menu.displayMenu();
            System.out.print("Enter your Choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.println(Colors.RED + "Invalid option! Please enter a number between 1 and 6!" + Colors.RESET);
                }
            } else {
                System.out.println(Colors.RED + "Invalid input! Please enter a valid number!" + Colors.RESET);
                scanner.nextLine();
            }
        }

        switch (choice) {
            case 1:
                clear();
                menu.BMI();
                double weight = -1, height = -1;
                while (weight < 0 || weight > 200) {
                    System.out.print("Enter your current weight (kg): ");
                    if (scanner.hasNextDouble()) {
                        weight = scanner.nextDouble();
                    } else {
                        System.out.println("Invalid input! Please enter a valid number for weight.");
                        scanner.next();
                    }
                }
                while (height < 0 || height > 2.5) {
                    System.out.print("Enter your current height (m): ");
                    if (scanner.hasNextDouble()) {
                        height = scanner.nextDouble();
                    } else {
                        System.out.println("Invalid input! Please enter a valid number for height.");
                        scanner.next();
                    }
                }
                BMI bmi = new BMI(name, age, gender, weight, height);
                bmi.displayResult();
                break;
            case 2:
                clear();
                menu.step();
                int step = -1, stepGoal = -1;
                
                while (step < 1) {
                    System.out.print("Enter the number of steps you've walked today: ");
                    if (scanner.hasNextInt()) {
                        step = scanner.nextInt();
                    } else {
                        System.out.println("Invalid input! Please enter a positive number.");
                        scanner.next();
                    }
                }
                while (stepGoal < 1) {
                    System.out.print("Enter your goal step count: ");
                    if (scanner.hasNextInt()) {
                        stepGoal = scanner.nextInt();
                    } else {
                        System.out.println("Invalid input! Please enter a positive number.");
                        scanner.next();
                    }
                }
                
                System.out.println("Step data recorded successfully!");
                break;
            case 3:
                clear();
                menu.water();
                double goal;
                while (true) {
                    System.out.print("Enter your daily water intake goal (liters): ");
                    if (scanner.hasNextDouble()) {
                        goal = scanner.nextDouble();
                        if (goal > 0) break;
                    }
                    System.out.println("Invalid input! Please enter a positive number.");
                    scanner.next();
                }
                WaterTracker waterTracker = new WaterTracker(goal, name, age, gender);
                waterTracker.displayResult();
                break;
            case 4:
                clear();
                menu.sleep();
                SleepTracker sleepTracker = new SleepTracker(name, age, gender);
                sleepTracker.inputData();
                sleepTracker.displayResult();
                break;
            case 5:
                clear();
                menu.heart();
                HeartTracker heartTracker = new HeartTracker(name, age, gender);
                heartTracker.process();
                heartTracker.displayResult();
                break;
            case 6:
                clear();
                menu.thank();
                System.out.println("Thank you for using our program!");
                System.exit(0);
                break;
        }
        scanner.close();
    }
}