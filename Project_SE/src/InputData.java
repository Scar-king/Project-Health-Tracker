
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputData {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/health_tracker", "root", System.getenv("PASSWORD"));
    }

    public static void clear() {
        try {
            System.out.println("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    void InputValue() {
        Scanner scanner = new Scanner(System.in);

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

        int age = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter your Age: ");
                age = scanner.nextInt();
                scanner.nextLine();

                if (age >= 15 && age <= 100) {
                    validInput = true;
                } else {
                    System.out.println(Colors.RED + "Invalid input! Age must be between 15 and 100" + Colors.RESET);
                }
            } catch (Exception e) {
                System.out.println(Colors.RED + "Invalid input! Please enter a number only!" + Colors.RESET);
                scanner.nextLine();
            }
        }

        String gender = "";
        boolean validGender = false;

        while (!validGender) {
            System.out.print("Enter your Gender (M/F): ");
            gender = scanner.nextLine().trim().toUpperCase();

            if (gender.equals("M") || gender.equals("F")) {
                validGender = true;
            } else {
                System.out.println(Colors.RED + "Invalid input! Please enter 'M' or 'F'" + Colors.RESET);
            }
        }

        clear();
        Menu menu = new Menu();

        int choice = -1;
        boolean validChoice = false;
        while (choice != 6) {

            menu.displayMenu();
            System.out.print("Enter your Choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= 6) {
                    validChoice = true;
                } else {
                    System.out.println(Colors.RED + "Invalid option! Please enter a number between 1 and 6!" + Colors.RESET);
                    validChoice = false;
                }
            } else {
                System.out.println(Colors.RED + "Invalid input! Please enter a valid number!" + Colors.RESET);
                scanner.nextLine();
                validChoice = false;
            }

            if (validChoice) {
                switch (choice) {
                    case 1:
                        clear();
                        menu.BMI();
                        double weight = -1;
                        boolean validWeight = false;
                        while (!validWeight) {
                            try {
                                System.out.print("Enter your current weight (kg): ");
                                weight = scanner.nextDouble();
                                if (weight >= 20 && weight <= 200) {
                                    validWeight = true;
                                } else {
                                    System.out.println(Colors.RED + "Oops! Weight should be a positive number greater than 20 and should be less than 200 (kg). Please try again." + Colors.RESET);
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(Colors.RED + "Invalid input! Please enter a valid number for weight." + Colors.RESET);
                                scanner.nextLine();
                            }
                        }

                        double height = -1;
                        boolean validHeight = false;
                        while (!validHeight) {
                            try {
                                System.out.print("Enter your current height (m): ");
                                height = scanner.nextDouble();
                                if (height >= 1 && height <= 2.5) {
                                    validHeight = true;
                                } else {
                                    System.out.println(Colors.RED + "Oops! Height should be a positive number greater than 1 and should be less than 2.5 (m). Please try again." + Colors.RESET);
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(Colors.RED + "Invalid input! Please enter a valid number for height." + Colors.RESET);
                                scanner.nextLine();
                            }
                        }

                        BMI bmi = new BMI(name, age, gender, weight, height);
                        bmi.displayResult();

                        String query = "INSERT INTO bmi_data (Name, Age, Gender, Weight, Height, BMI, Date) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        try (Connection connection = getConnection(); 
                            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                            preparedStatement.setString(1, name);
                            preparedStatement.setInt(2, age);
                            preparedStatement.setString(3, gender);
                            preparedStatement.setDouble(4, weight);
                            preparedStatement.setDouble(5, height);
                            preparedStatement.setDouble(6, bmi.calculateBMI());
                            preparedStatement.setTimestamp(7, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

                            System.out.println(Colors.GREEN + "BMI data saved to database successfully!" + Colors.RESET);
                            preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                            System.out.println(Colors.RED + "Error while saving BMI data to database: " + e.getMessage() + Colors.RESET);
                        }

                        System.out.println("\n");
                        break;
                    case 2:
                        clear();
                        menu.step();
                        int step = -1,
                        stepGoal = -1;

                        while (step < 0) {
                            System.out.print("Enter the number of steps you've walked today: ");
                            if (scanner.hasNextInt()) {
                                step = scanner.nextInt();
                                if (step < 0) {
                                    System.out.println(Colors.RED + "Steps cannot be negative! Please enter a positive number." + Colors.RESET);
                                }
                            } else {
                                System.out.println(Colors.RED + "Oops! That doesn't look like a valid number. Please enter a positive number for steps." + Colors.RESET);
                                scanner.next();
                            }
                        }

                        while (stepGoal <= 0) {
                            System.out.print("Enter the number of your goal step: ");
                            if (scanner.hasNextDouble()) {
                                stepGoal = scanner.nextInt();
                                if (stepGoal <= 0) {
                                    System.out.println(Colors.RED + "Step goal must be greater than 0! Please try again." + Colors.RESET);
                                }
                            } else {
                                System.out.println(Colors.RED + "Oops! That doesn't look like a valid number. Please enter a positive number for your step goal." + Colors.RESET);
                                scanner.next();
                            }
                        }

                        double weightInStep = -1;
                        boolean validWeightInStep = false;
                        while (!validWeightInStep) {
                            try {
                                System.out.print("Enter your weight (kg): ");
                                weightInStep = scanner.nextDouble();
                                if (weightInStep >= 20 && weightInStep <= 200) {
                                    validWeightInStep = true;
                                } else {
                                    System.out.println(Colors.RED + "Oops! Weight should be a positive number greater than 20. Please try again." + Colors.RESET);
                                }
                            } catch (Exception e) {
                                System.out.println(Colors.RED + "Invalid input! Please enter a valid number for weight." + Colors.RESET);
                                scanner.nextLine();
                            }
                        }

                        stepTracker Step = new stepTracker(name, age, gender, step, stepGoal, weightInStep);
                        Step.displayResult();
                        System.out.println("\n");
                        break;
                    case 3:
                        clear();
                        menu.water();
                        double goal = -1;
                        boolean validGoal = false;
                        while(!validGoal) {
                            try {
                                System.out.print("Enter your daily water intake goal (in liters): ");
                                goal = scanner.nextDouble();
                                if(goal >= 0 && goal <= 5){
                                    validGoal = true;
                                } else {
                                    System.out.println(Colors.RED + "Oops! Water intake goal must be a positive number greater than 0 and less than 5L. Please try again." + Colors.RESET);
                                }
                            } catch (Exception e) {
                                System.out.println(Colors.RED + "Oops! That doesn't look like a valid number. Please enter a positive number for the water intake goal." + Colors.RESET);
                                scanner.nextLine();
                            }
                        }

                        WaterTracker waterTracker = new WaterTracker(goal, name, age, gender);
                        String userChoice = "yes";

                        while (userChoice.equalsIgnoreCase("yes") && waterTracker.getIntakeProgress() < 100) {

                            double waterAmount = -1;
                            boolean validWaterAmount = false;
                            while(!validWaterAmount) {
                                try {
                                    System.out.print("\nEnter the amount of water you drank (in liters): ");
                                    waterAmount = scanner.nextDouble();
                                    if(waterAmount >= 0 && waterAmount <= 5){
                                        validWaterAmount = true;
                                    } else {
                                        System.out.println(Colors.RED + "Oops! Water intake must be a positive number greater than 0 and less than 5L. Please try again." + Colors.RESET);
                                    }
                                } catch (Exception e) {
                                    System.out.println(Colors.RED + "Oops! That doesn't look like a valid number. Please enter a positive number for the water intake goal." + Colors.RESET);
                                    scanner.nextLine();
                                }
                            }

                            waterTracker.logWaterIntake(waterAmount);
                            waterTracker.displayResult();
                            System.out.println("Intake Progress: " + waterTracker.getIntakeProgress() + "%");
                            if (waterTracker.getIntakeProgress() == 100) {
                                System.out.println(Colors.BRIGHT_GREEN + "\nCongratulations! You've reached your water intake goal for the day!" + Colors.RESET);
                            }

                            if (waterTracker.getIntakeProgress() < 100) {
                                System.out.print("\nDo you want to log more water intake? (yes/no): ");
                                userChoice = scanner.next();
                                while (!userChoice.equalsIgnoreCase("yes") && !userChoice.equalsIgnoreCase("no")) {
                                    System.out.println(Colors.RED + "Invalid input! Please enter 'yes' or 'no'." + Colors.RESET);
                                    userChoice = scanner.next();
                                }
                            }
                        }
                        System.out.println("\n");
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
                    
                        String exitChoice = "";
                        while (!exitChoice.equalsIgnoreCase("yes") && !exitChoice.equalsIgnoreCase("no")) {
                            System.out.print(Colors.YELLOW + "Are you sure you want to exit? (yes/no): " + Colors.RESET);
                            exitChoice = scanner.next().trim().toLowerCase();

                            if (exitChoice.equals("yes")) {
                                menu.thank();
                                System.out.println(Colors.PINK_TRUE_COLOR + "╔════════════════════════════════════════╗" + Colors.RESET);
                                System.out.println(Colors.PINK_TRUE_COLOR + "║      Thank you for using our program   ║" + Colors.RESET);
                                System.out.println(Colors.PINK_TRUE_COLOR + "║                   (><)                 ║" + Colors.RESET);
                                System.out.println(Colors.PINK_TRUE_COLOR + "╚════════════════════════════════════════╝" + Colors.RESET);
                                System.exit(0); 
                            } else if (exitChoice.equals("no")) {
                                clear();
                                choice = -1; 
                                break; 
                            } else {
                                System.out.println(Colors.RED + "Invalid input! Please enter 'yes' or 'no'." + Colors.RESET);
                            }
                        }
                        break;

                    default:
                        System.out.println(Colors.GREEN + "Please Choice Correct Option!" + Colors.RESET);
                        break;
                }
            }
        }
        scanner.close();
    }
}
