package Project;

public class Menu {

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
    
    }
}


