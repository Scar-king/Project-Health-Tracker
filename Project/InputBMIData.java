package Project;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class InputBMIData {
    void InputValue(){
        Scanner scanner = new Scanner(System.in);
        String filename = "BMI.txt";
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
    
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
    
        scanner.nextLine();
        System.out.print("Enter your gender (M/F): ");
        String gender = scanner.nextLine();

        Menu menu = new Menu();
        menu.displayMenu();

        int choice;
        do{
            choice = scanner.nextInt();
            switch(choice){
                case 1: 
                    System.out.print("Enter your current weight (kg): ");
                    double weight = scanner.nextDouble();
                
                    System.out.print("Enter your current height (m): ");
                    double height = scanner.nextDouble();
                    
                    BMI bmi = new BMI(name, age, gender, weight, height);
                    bmi.displayResult();
                    try {
                        RandomAccessFile file = new RandomAccessFile(filename, "rw");
                        
                        if (file.length() == 0) {
                            file.writeBytes("---------------------------------------------------------------------------------------------------\n");
                            file.writeBytes(String.format("| %-20s | %-5s | %-10s | %-10s | %-10s | %-10s | %-13s|\n","NAME", "AGE", "GENDER", "WEIGHT", "HEIGHT", "BMI", "DATE"));
                            file.writeBytes("---------------------------------------------------------------------------------------------------\n");
                        }

                        file.seek(file.length());

                        file.writeBytes(String.format("| %-20s | %-5d | %-10s | %-10.2f | %-10.2f | %-10.2f | %-13s|\n", name, age, gender.toUpperCase(), weight, height, bmi.calculateBMI(), java.time.LocalDate.now()));
                        file.writeBytes("---------------------------------------------------------------------------------------------------\n");

                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                    case 2:
                        System.out.print("Enter the number of steps you've walked today: ");
                        int step = scanner.nextInt();
                        System.out.print("Enter the number of your goal step: ");
                        int stepGoal = scanner.nextInt();
                        System.out.println("Enter your weight (kg): ");
                        double weightInStep = scanner.nextDouble();
                        stepTracker Step = new stepTracker(name, age, gender, step, stepGoal, weightInStep);
                        Step.displayResult();
                        break;

                default:
                    System.out.println("Error");
            }
        } while(choice != 3);
        scanner.close();
    }
}
