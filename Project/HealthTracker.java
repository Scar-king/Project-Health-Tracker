package Project;

public abstract class HealthTracker {
    protected String name;
    protected int age;
    protected char gender;
    protected double weight, height;

    public HealthTracker(String name, int age, char gender, double weight, double height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    public abstract double calculateBMI();
    public abstract void displayResult();
}
