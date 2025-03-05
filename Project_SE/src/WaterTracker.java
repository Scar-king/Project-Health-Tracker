public class WaterTracker extends Client {
    double totalWaterIntake;
    double goalWaterIntake;
    String hydrationLevel;

    public WaterTracker(double goalWaterIntake, String name, int age, String gender){
        super(name, age, gender);
        this.goalWaterIntake = goalWaterIntake;
        this.totalWaterIntake = 0.0;
        this.hydrationLevel = "Not tracked yet";
    }

    public void logWaterIntake(double waterAmount){
        this.totalWaterIntake += waterAmount;
        updateHydrationLevel();
    }

    private void updateHydrationLevel(){
        this.hydrationLevel = (totalWaterIntake >= goalWaterIntake) ? "Hydrated" : "Dehydrated";
    }

    public double getIntakeProgress() {
        double progress = (totalWaterIntake / goalWaterIntake) * 100;
        if(progress > 100){
            progress = 100;
        }
        return progress;
    }

    @Override
    public void displayResult() {
        if(gender.equalsIgnoreCase("M")){
            System.out.println("\nHealth Report for Mr. " + Colors.GREEN + name + Colors.RESET + ":");
        } else {
            System.out.println("\nHealth Report for Ms. " + Colors.GREEN + name + Colors.RESET + ":");
        }
        System.out.println("Total Water Intake: " + totalWaterIntake + " L ");
        System.out.println("Goal: " + goalWaterIntake + " L ");
        System.out.println("Hydration Level: " + hydrationLevel);
    }
}

