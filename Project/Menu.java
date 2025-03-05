package Project;

public class Menu {

<<<<<<< HEAD
    void welcome(){
        System.out.println(Colors.BRIGHT_YELLOW + 
    "\t█████████████████████████████████████████████\n" +
    "\t█                                           █\n" +
    "\t█      Welcome to the Health Tracker!       █\n" +
    "\t█   Your journey to a healthier you starts  █\n" +
    "\t█              right here!                  █\n" +
    "\t█                                           █\n" +
    "\t█████████████████████████████████████████████" + 
    Colors.RESET);
    System.out.println();

    }

    void displayMenu(){
        System.out.println(Colors.BRIGHT_YELLOW + 
        "\n\t\t╔════════════════════════╗\n" +
        "\t\t║      Health Tracker    ║\n" +
        "\t\t╠════════════════════════╣\n" +
        "\t\t║ 1. BMI                 ║\n" +
        "\t\t║ 2. Step Tracker        ║\n" +
        "\t\t║ 3. Water Tracker       ║\n" +
        "\t\t║ 4. Sleep Tracker       ║\n" +
        "\t\t║ 5. Heart Tracker       ║\n" +
        "\t\t╚════════════════════════╝\n" + 
        Colors.RESET);
    
=======
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
>>>>>>> b95019a5ba2a6adbc48a8d22feed9bfa479b3ef6
    }
}
