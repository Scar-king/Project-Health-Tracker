package Project;

public class Menu {

    public void welcome() {
        System.out.println("***********************************************");
        System.out.println("**                                           **");
        System.out.println("**      Welcome to the Health Tracker!       **");
        System.out.println("**   Your journey to a healthier you starts  **");
        System.out.println("**              right here!                  **");
        System.out.println("**                                           **");
        System.out.println("***********************************************");
    }

    public void displayMenu() {
        System.out.println("------------------------");
        System.out.printf("| %-10s       |\n", "Health Tracker");
        System.out.println("------------------------");
        System.out.printf("| %-14s       |\n", "1. BMI");
        System.out.printf("| %-6s      |\n", "2. Step Tracker");
        System.out.printf("| %-6s      |\n", "3. Exit");
        System.out.println("------------------------");
        System.out.print("Enter your choice: ");
    }
}
