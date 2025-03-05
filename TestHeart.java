import java.util.Scanner;

public class TestHeart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to Heart Rate Monitor! ");

        // Get user age
        System.out.print(" Enter your age: ");
        int age = scanner.nextInt();

        // Get resting heart rate
        System.out.print(" Enter your resting heart rate (BPM): ");
        int restingHR = scanner.nextInt();

        // Calculate max heart rate (MHR)
        int maxHR = 220 - age;

        // Calculate heart rate reserve (HRR)
        int hrr = maxHR - restingHR;

        // Display heart rate zones
        System.out.println("\n Heart Rate Zones:");
        System.out.println(" Resting Zone (<50% of Max HR): < " + (int) (maxHR * 0.5) + " BPM");
        System.out.println(" Fat Burn Zone (50-70% of Max HR): " + (int) (maxHR * 0.5) + " - " + (int) (maxHR * 0.7) + " BPM");
        System.out.println(" Cardio Zone (70-85% of Max HR): " + (int) (maxHR * 0.7) + " - " + (int) (maxHR * 0.85) + " BPM");
        System.out.println(" Peak Zone (85-100% of Max HR): > " + (int) (maxHR * 0.85) + " BPM");

        // Get real-time heart rate
        System.out.print("\n Enter your current heart rate (BPM): ");
        int currentHR = scanner.nextInt();

        // Determine heart rate zone
        String zone;
        if (currentHR < maxHR * 0.5) {
            zone = " Resting Zone";
        } else if (currentHR < maxHR * 0.7) {
            zone = " Fat Burn Zone";
        } else if (currentHR < maxHR * 0.85) {
            zone = " Cardio Zone";
        } else {
            zone = " Peak Zone";
        }

        // Display results
        System.out.println("\n===============================");
        System.out.println(" Max Heart Rate: " + maxHR + " BPM");
        System.out.println(" Your Current Heart Rate: " + currentHR + " BPM");
        System.out.println(" Heart Rate Zone: " + zone);
        System.out.println("===============================");

        scanner.close();
    }
}
