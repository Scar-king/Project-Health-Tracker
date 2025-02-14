package Project;

public abstract class Client {
    protected String name;
    protected int age;
    protected String gender;
    protected double heartRate;
    protected double caloriesBurned;
    protected double waterIntake;
    protected double sleepHours;
    protected String bloodPressure;
    protected double bloodSugar;

    public Client(String name, int age, String gender, double heartRate, double caloriesBurned, double waterIntake, double sleepHours, String bloodPressure, double bloodSugar) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.heartRate = heartRate;
        this.caloriesBurned = caloriesBurned;
        this.waterIntake = waterIntake;
        this.sleepHours = sleepHours;
        this.bloodPressure = bloodPressure;
        this.bloodSugar = bloodSugar;
    }
    
    public abstract void displayResult();
}