public class stepTracker extends Client {
    int stepCount;
    int stepGoal;
    double weight;
    stepTracker(String name, int age, String gender, int stepCount, int stepGoal, double weight){
        super(name, age, gender);
        this.stepCount = stepCount;
        this.stepGoal = stepGoal;
        this.weight = weight;
    }

    int remainingSteps(){
        return stepGoal - stepCount;
    }

    double caloriesBurned(){
        return ((double)stepCount / 2000) * weight;
    }

    @Override
    public void displayResult() {
        if(gender.equalsIgnoreCase("M")){
            System.out.println("\nHealth Report for Mr. " + Colors.GREEN + name + Colors.RESET + ":");
        } else {
            System.out.println("\nHealth Report for Ms. " + Colors.GREEN + name + Colors.RESET + ":");
        }
        System.out.printf("Total steps today: %d step\n", stepCount);
        System.out.printf("Your step goal: %d steps\n", stepGoal);
        if(stepCount < stepGoal){
            System.out.printf("You need %d more steps to reach your goal!\n", remainingSteps());
        } else {
            System.out.println("Well, done!");
        }
        if(stepCount >= stepGoal){
            System.out.println("Great job! You've met your step goal for today.");
        } else {
            System.out.println("You're doing well! Keep walking to reach your goal.");
        }
        System.out.printf("Calories burned today: %.2f calories\n", caloriesBurned());
        System.out.println("Remember: Keep moving! Stay active to improve your overall health.");
    }
}
