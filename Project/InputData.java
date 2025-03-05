package Project;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

<<<<<<< HEAD:Project/InputData.java
public class InputData {

    public static void clear(){
        try{
            System.out.println("\033[H\033[2J");
            System.out.flush();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    void InputValue(){
=======
public class InputBMIData {
    void InputValue() {
>>>>>>> b95019a5ba2a6adbc48a8d22feed9bfa479b3ef6:Project/InputBMIData.java
        Scanner scanner = new Scanner(System.in);
        String filename = "BMI.txt";

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
    
        scanner.nextLine();
        System.out.print("Enter your gender (M/F): ");
        String gender = scanner.nextLine();
<<<<<<< HEAD:Project/InputData.java
        clear();

        Menu menu = new Menu();
        

        int choice;
        do{
            menu.displayMenu();
            System.out.print("Enter your Choice: ");
            choice = scanner.nextInt();
            switch(choice){
                case 1: 
                    clear();
=======
        
        System.out.print("Enter your heart rate (bpm): ");
        int heartRate = scanner.nextInt();
        
        System.out.print("Enter calories burned today: ");
        double caloriesBurned = scanner.nextDouble();
        
        System.out.print("Enter water intake (liters): ");
        double waterIntake = scanner.nextDouble();
        
        System.out.print("Enter sleep hours: ");
        double sleepHours = scanner.nextDouble();
        
        System.out.print("Enter blood pressure (mmHg): ");
        scanner.nextLine();
        String bloodPressure = scanner.nextLine();
        
        System.out.print("Enter blood sugar level (mg/dL): ");
        double bloodSugar = scanner.nextDouble();
    
        Menu menu = new Menu();
        menu.displayMenu();
    
        int choice;
        do {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
>>>>>>> b95019a5ba2a6adbc48a8d22feed9bfa479b3ef6:Project/InputBMIData.java
                    System.out.print("Enter your current weight (kg): ");
                    double weight = scanner.nextDouble();
                    
                    System.out.print("Enter your current height (m): ");
                    double height = scanner.nextDouble();
                    
<<<<<<< HEAD:Project/InputData.java
                    
                    BMI bmi = new BMI(name, age, gender, weight, height);
=======
                    BMI bmi = new BMI(name, age, gender, weight, height, heartRate, caloriesBurned, waterIntake, sleepHours, bloodPressure, bloodSugar);
>>>>>>> b95019a5ba2a6adbc48a8d22feed9bfa479b3ef6:Project/InputBMIData.java
                    bmi.displayResult();
                    try {
                        RandomAccessFile file = new RandomAccessFile(filename, "rw");
                        
                        if (file.length() == 0) {
                            file.writeBytes("---------------------------------------------------------------------------------------------------\n");
                            file.writeBytes(String.format("| %-20s | %-5s | %-10s | %-10s | %-10s | %-10s | %-13s|\n", "NAME", "AGE", "GENDER", "WEIGHT", "HEIGHT", "BMI", "DATE"));
                            file.writeBytes("---------------------------------------------------------------------------------------------------\n");
                        }
    
                        file.seek(file.length());
    
                        file.writeBytes(String.format("| %-20s | %-5d | %-10s | %-10.2f | %-10.2f | %-10.2f | %-13s|\n", name, age, gender.toUpperCase(), weight, height, bmi.calculateBMI(), java.time.LocalDate.now()));
                        file.writeBytes("---------------------------------------------------------------------------------------------------\n");
    
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\n");
                    break;
<<<<<<< HEAD:Project/InputData.java
                    case 2:
                    clear();
                        System.out.print("Enter the number of steps you've walked today: ");
                        int step = scanner.nextInt();
                        System.out.print("Enter the number of your goal step: ");
                        int stepGoal = scanner.nextInt();
                        System.out.print("Enter your weight (kg): ");
                        double weightInStep = scanner.nextDouble();
                        stepTracker Step = new stepTracker(name, age, gender, step, stepGoal, weightInStep);
                        Step.displayResult();
                        System.out.println("\n");
                        break;
                    case 3: 
                    clear();
                        double goal;
                        System.out.println("\t***Note. Positive number only!***");
                        do{
                            System.out.print("Enter your daily water intake goal (in liters): ");
                            goal = scanner.nextDouble();
                        } while(goal <= 0);

                        WaterTracker waterTracker = new WaterTracker(goal, name, age, gender);
                        String userChoice = "yes";
                        while (userChoice.equalsIgnoreCase("yes") && waterTracker.getIntakeProgress() < 100){
                            System.out.print("\nEnter the amount of water you drank (in liters): ");
                            double waterAmount = scanner.nextDouble();
                            waterTracker.logWaterIntake(waterAmount);
                            waterTracker.displayResult();
                            System.out.println("Intake Progress: " + waterTracker.getIntakeProgress() + "%");
                            if(waterTracker.getIntakeProgress() < 100){
                                System.out.print("\nDo you want to log more water intake? (yes/no): ");
                                userChoice = scanner.next();
                            }
                        }
                        System.out.println("\n");
                        break;

                    case 4:
                    clear();
                        SleepTracker sleepTracker = new SleepTracker(name, age, gender);
                        sleepTracker.inputData();
                        sleepTracker.displayResult();
                        break;

                    case 5:
                    clear();
                        HeartTracker heartTracker = new HeartTracker(name, age, gender);
                        heartTracker.process();
                        heartTracker.displayResult();
                        break;
                           
                    case 10:
                    clear();
                        System.exit(0);
                    default:
                        System.out.println("Error");
                        System.out.println("\n");
                        menu.displayMenu();
            }
        } while(choice != 10);
=======
                case 2:
                    System.out.print("Enter the number of steps you've walked today: ");
                    int step = scanner.nextInt();
                    System.out.print("Enter the number of your goal step: ");
                    int stepGoal = scanner.nextInt();
                    System.out.println("Enter your weight (kg): ");
                    double weightInStep = scanner.nextDouble();
                    stepTracker Step = new stepTracker(name, age, gender, step, stepGoal, weightInStep, heartRate, caloriesBurned, waterIntake, sleepHours, bloodPressure, bloodSugar);
                    Step.displayResult();
                    break;
                case 3:
                    System.out.println("Thank you for using the Health Tracker!");
                    break;
                default:
                    System.out.println("Error");
            }
        } while (choice != 3);
>>>>>>> b95019a5ba2a6adbc48a8d22feed9bfa479b3ef6:Project/InputBMIData.java
        scanner.close();
    }
}
