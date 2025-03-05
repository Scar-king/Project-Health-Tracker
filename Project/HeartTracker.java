package Project;

import java.util.Scanner;

public class HeartTracker extends Client {
    private int restingHR;
    private int maxHR;
    private int hrr;
    private int currentHR;
    private Scanner scanner;

    public HeartTracker(String name, int age, String gender) {
        super(name, age, gender);
        this.restingHR = 0;
        this.maxHR = 220 - age;
        this.hrr = 0;
        this.currentHR = 0;
        this.scanner = new Scanner(System.in);  // Initialize scanner once
    }

    public void process() {
        System.out.println("Welcome to Heart Rate Monitor!");

        System.out.print("Enter your resting heart rate (BPM): ");
        this.restingHR = scanner.nextInt();
        this.hrr = maxHR - restingHR;

        System.out.println("\nHeart Rate Zones:");
        System.out.println(" Resting Zone (<50% of Max HR): < " + (int) (maxHR * 0.5) + " BPM");
        System.out.println(" Fat Burn Zone (50-70% of Max HR): " + (int) (maxHR * 0.5) + " - " + (int) (maxHR * 0.7) + " BPM");
        System.out.println(" Cardio Zone (70-85% of Max HR): " + (int) (maxHR * 0.7) + " - " + (int) (maxHR * 0.85) + " BPM");
        System.out.println(" Peak Zone (85-100% of Max HR): > " + (int) (maxHR * 0.85) + " BPM");

        System.out.print("\nEnter your current heart rate (BPM): ");
        this.currentHR = scanner.nextInt();
    }

    @Override
    public void displayResult() {
        String zone;
        if (currentHR < maxHR * 0.5) {
            zone = "Resting Zone";
        } else if (currentHR < maxHR * 0.7) {
            zone = "Fat Burn Zone";
        } else if (currentHR < maxHR * 0.85) {
            zone = "Cardio Zone";
        } else {
            zone = "Peak Zone";
        }

        System.out.println("\n===============================");
        System.out.println(" Max Heart Rate: " + maxHR + " BPM");
        System.out.println(" Your Current Heart Rate: " + currentHR + " BPM");
        System.out.println(" Heart Rate Zone: " + zone);
        System.out.println("===============================");
    }

    // Getters (if needed)
    public int getRestingHR() { return restingHR; }
    public int getMaxHR() { return maxHR; }
    public int getHrr() { return hrr; }
    public int getCurrentHR() { return currentHR; }
}
