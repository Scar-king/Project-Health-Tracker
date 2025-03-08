public class Menu {

    void welcome(){
        System.out.println(Colors.BRIGHT_YELLOW + 
        "\t█████████████████████████████████████████████\n" +
        "\t█                                           █\n" +
        "\t█       Welcome to the Health Tracker!      █\n" +
        "\t█  Your journey to a healthier you starts   █\n" +
        "\t█               right here!                 █\n" +
        "\t█                                           █\n" +
        "\t█████████████████████████████████████████████" + 
        Colors.RESET);
        System.out.println();
    }

    void displayMenu(){
        System.out.println(Colors.BRIGHT_YELLOW + 
        "\n\t\t╔════════════════════════════════════════╗\n" +
        "\t\t║          Health Tracker Menu           ║\n" +
        "\t\t╠════════════════════════════════════════╣\n" +
        "\t\t║  1. " + Colors.CYAN + "BMI (Body Mass Index)" + Colors.BRIGHT_YELLOW + "              ║\n" +
        "\t\t║  2. " + Colors.CYAN + "Step Tracker" + Colors.BRIGHT_YELLOW + "                       ║\n" +
        "\t\t║  3. " + Colors.CYAN + "Water Tracker" + Colors.BRIGHT_YELLOW + "                      ║\n" +
        "\t\t║  4. " + Colors.CYAN + "Sleep Tracker" + Colors.BRIGHT_YELLOW + "                      ║\n" +
        "\t\t║  5. " + Colors.CYAN + "Heart Tracker" + Colors.BRIGHT_YELLOW + "                      ║\n" +
        "\t\t║  6. " + Colors.RED + "Exit" + Colors.BRIGHT_YELLOW + "                               ║\n" +
        "\t\t╚════════════════════════════════════════╝\n" + 
        Colors.RESET);
    } 
}


