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
    void BMI(){
        System.out.println(Colors.BRIGHT_GREEN+"/$$$$$$$  /$$      /$$ /$$$$$$"+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"| $$__  $$| $$$    /$$$|_  $$_/"+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"| $$  \\ $$| $$$$  /$$$$  | $$  "+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"| $$$$$$$ | $$ $$/$$ $$  | $$  "+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"| $$__  $$| $$  $$$| $$  | $$  "+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"| $$  \\ $$| $$\\  $ | $$  | $$  "+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"| $$$$$$$/| $$ \\/  | $$ /$$$$$$"+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"|_______/ |__/     |__/|______/"+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"                               "+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"                               "+Colors.RESET);
        System.out.println(Colors.BRIGHT_GREEN+"                               "+Colors.RESET);
    }

    void step(){
        System.out.println(Colors.PURPLE+"/$$$$$$   /$$                               /$$$$$$$$                           /$$                          "+Colors.RESET);
        System.out.println(Colors.PURPLE+" /$$__  $$ | $$                              |__  $$__/                          | $$                          "+Colors.RESET);
        System.out.println(Colors.PURPLE+"| $$  \\__//$$$$$$    /$$$$$$   /$$$$$$          | $$  /$$$$$$  /$$$$$$   /$$$$$$$| $$   /$$  /$$$$$$   /$$$$$$ "+Colors.RESET);
        System.out.println(Colors.PURPLE+"|  $$$$$$|_  $$_/   /$$__  $$ /$$__  $$         | $$ /$$__  $$|____  $$ /$$_____/| $$  /$$/ /$$__  $$ /$$__  $$"+Colors.RESET);
        System.out.println(Colors.PURPLE+" \\____  $$ | $$    | $$$$$$$$| $$  \\ $$         | $$| $$  \\__/ /$$$$$$$| $$      | $$$$$$/ | $$$$$$$$| $$  \\__/"+Colors.RESET);
        System.out.println(Colors.PURPLE+" /$$  \\ $$ | $$ /$$| $$_____/| $$  | $$         | $$| $$      /$$__  $$| $$      | $$_  $$ | $$_____/| $$      "+Colors.RESET);
        System.out.println(Colors.PURPLE+"|  $$$$$$/ |  $$$$/|  $$$$$$$| $$$$$$$/         | $$| $$     |  $$$$$$$|  $$$$$$$| $$ \\  $$|  $$$$$$$| $$      "+Colors.RESET);
        System.out.println(Colors.PURPLE+" \\______/   \\___/   \\_______/| $$____/          |__/|__/      \\_______/ \\_______/|__/  \\__/ \\_______/|__/      "+Colors.RESET);
        System.out.println(Colors.PURPLE+"                             | $$                                                                              "+Colors.RESET);
        System.out.println(Colors.PURPLE+"                             | $$                                                                              "+Colors.RESET);
        System.out.println(Colors.PURPLE+"                             |__/                                                                              "+Colors.RESET);
    }

    void water(){
        System.out.println(Colors.BLUE+"/$$      /$$             /$$                               /$$$$$$$$                               /$$                          "+Colors.RESET);
        System.out.println(Colors.BLUE+"| $$  /$ | $$            | $$                              |__  $$__/                              | $$                          "+Colors.RESET);
        System.out.println(Colors.BLUE+"| $$ /$$$| $$  /$$$$$$  /$$$$$$    /$$$$$$   /$$$$$$          | $$     /$$$$$$   /$$$$$$   /$$$$$$$| $$   /$$  /$$$$$$   /$$$$$$ "+Colors.RESET);
        System.out.println(Colors.BLUE+"| $$/$$ $$ $$ |____  $$|_  $$_/   /$$__  $$ /$$__  $$         | $$    /$$__  $$ |____  $$ /$$_____/| $$  /$$/ /$$__  $$ /$$__  $$"+Colors.RESET);
        System.out.println(Colors.BLUE+"| $$$$_  $$$$  /$$$$$$$  | $$    | $$$$$$$$| $$  \\__/         | $$   | $$  \\__/  /$$$$$$$| $$      | $$$$$$/ | $$$$$$$$| $$  \\__/"+Colors.RESET);
        System.out.println(Colors.BLUE+"| $$$/ \\  $$$ /$$__  $$  | $$ /$$| $$_____/| $$               | $$   | $$       /$$__  $$| $$      | $$_  $$ | $$_____/| $$      "+Colors.RESET);
        System.out.println(Colors.BLUE+"| $$/   \\  $$|  $$$$$$$  |  $$$$/|  $$$$$$$| $$               | $$   | $$      |  $$$$$$$|  $$$$$$$| $$ \\  $$|  $$$$$$$| $$      "+Colors.RESET);
        System.out.println(Colors.BLUE+"|__/     \\__/ \\_______/   \\___/   \\_______/|__/               |__/   |__/       \\_______/ \\_______/|__/  \\__/ \\_______/|__/      "+Colors.RESET);
    }

    void sleep(){
        System.out.println(Colors.BRIGHT_CYAN+"/$$$$$$  /$$                                       /$$$$$$$$          v                     /$$                          "+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+"/$$__  $$| $$                                    |__  $$__/                              | $$                          "+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+"| $$  \\__/| $$  /$$$$$$   /$$$$$$   /$$$$$$          | $$     /$$$$$$   /$$$$$$   /$$$$$$$| $$   /$$  /$$$$$$   /$$$$$$ "+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+"|  $$$$$$ | $$ /$$__  $$ /$$__  $$ /$$__  $$         | $$    /$$__  $$ |____  $$ /$$_____/| $$  /$$/ /$$__  $$ /$$__  $$"+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+" \\____  $$| $$| $$$$$$$$| $$$$$$$$| $$  \\ $$         | $$   | $$  \\__/  /$$$$$$$| $$      | $$$$$$/ | $$$$$$$$| $$  \\__/"+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+"/$$  \\ $$| $$| $$_____/| $$_____/| $$  | $$         | $$   | $$       /$$__  $$| $$      | $$_  $$ | $$_____/| $$      "+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+"|  $$$$$$/| $$|  $$$$$$$|  $$$$$$$| $$$$$$$/         | $$   | $$      |  $$$$$$$|  $$$$$$$| $$ \\  $$|  $$$$$$$| $$      "+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+" \\______/ |__/ \\_______/ \\_______/| $$____/          |__/   |__/       \\_______/ \\_______/|__/  \\__/ \\_______/|__/      "+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+"                                  | $$                                                                                  "+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+"                                  | $$                                                                                  "+Colors.RESET);
        System.out.println(Colors.BRIGHT_CYAN+"                                  |__/                                                                                  "+Colors.RESET);

    }

    void heart(){
        System.out.println(Colors.BRIGHT_RED+"/$$   /$$                                 /$$           /$$$$$$$$                               /$$                          ");
        System.out.println(Colors.BRIGHT_RED+"| $$  | $$                                | $$          |__  $$__/                              | $$                          ");
        System.out.println(Colors.BRIGHT_RED+"| $$  | $$  /$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$           | $$     /$$$$$$   /$$$$$$   /$$$$$$$| $$   /$$  /$$$$$$   /$$$$$$ ");
        System.out.println(Colors.BRIGHT_RED+"| $$$$$$$$ /$$__  $$ |____  $$ /$$__  $$|_  $$_/           | $$    /$$__  $$ |____  $$ /$$_____/| $$  /$$/ /$$__  $$ /$$__  $$");
        System.out.println(Colors.BRIGHT_RED+"| $$__  $$| $$$$$$$$  /$$$$$$$| $$  \\__/  | $$             | $$   | $$  \\__/  /$$$$$$$| $$      | $$$$$$/ | $$$$$$$$| $$  \\__/");
        System.out.println(Colors.BRIGHT_RED+"| $$  | $$| $$_____/ /$$__  $$| $$        | $$ /$$         | $$   | $$       /$$__  $$| $$      | $$_  $$ | $$_____/| $$      ");
        System.out.println(Colors.BRIGHT_RED+"| $$  | $$|  $$$$$$$|  $$$$$$$| $$        |  $$$$/         | $$   | $$      |  $$$$$$$|  $$$$$$$| $$ \\  $$|  $$$$$$$| $$      ");
        System.out.println(Colors.BRIGHT_RED+"|__/  |__/ \\_______/ \\_______/|__/         \\___/           |__/   |__/       \\_______/ \\_______/|__/  \\__/ \\_______/|__/      ");
    }
    void thank(){
        System.out.println(Colors.PINK_TRUE_COLOR + "/$$$$$$$$ /$$                           /$$                                                 /$$ /$$" + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "|__  $$__/| $$                          | $$                                                | $$| $$" + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "   | $$   | $$$$$$$   /$$$$$$  /$$$$$$$ | $$   /$$       /$$   /$$  /$$$$$$  /$$   /$$      | $$| $$" + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "   | $$   | $$__  $$ |____  $$| $$__  $$| $$  /$$/      | $$  | $$ /$$__  $$| $$  | $$      | $$| $$" + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "   | $$   | $$  \\ $$  /$$$$$$$| $$  \\ $$| $$$$$$/       | $$  | $$| $$  \\ $$| $$  | $$      |__/|__/" + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "   | $$   | $$  | $$ /$$__  $$| $$  | $$| $$_  $$       | $$  | $$| $$  | $$| $$  | $$             " + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "   | $$   | $$  | $$|  $$$$$$$| $$  | $$| $$ \\  $$      |  $$$$$$$|  $$$$$$/|  $$$$$$/       /$$ /$$" + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "   |__/   |__/  |__/ \\_______/|__/  |__/|__/  \\__/       \\____  $$ \\______/  \\______/       |__/|__/" + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "                                                         /$$  | $$                                  " + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "                                                        |  $$$$$$/                                  " + Colors.RESET);
        System.out.println(Colors.PINK_TRUE_COLOR + "                                                         \\______/                                   " + Colors.RESET);
    }
}


