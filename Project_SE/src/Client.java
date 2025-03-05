

public abstract class Client {
    protected String name;
    protected int age;
    protected String gender;

    public Client(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    public abstract void displayResult();
}
