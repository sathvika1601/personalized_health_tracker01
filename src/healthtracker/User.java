package healthtracker;
import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private double weight;
    private int stepGoal;
    private double sleepGoal;
    private double waterGoal;
    private ArrayList<HealthData> weeklyData;

    public User(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.weeklyData = new ArrayList<>();

        // Default goals
        this.stepGoal = 5000;
        this.sleepGoal = 7;
        this.waterGoal = 2;
    }

    public void addHealthData(HealthData data) {
        weeklyData.add(data);
        FileHandler.saveData(this); // Save data each time
    }

    public void setGoals(int stepGoal, double sleepGoal, double waterGoal) {
        this.stepGoal = stepGoal;
        this.sleepGoal = sleepGoal;
        this.waterGoal = waterGoal;
    }

    public void printWeeklySummary() {
        int totalSteps = 0;
        double totalSleep = 0, totalWater = 0;

        for (HealthData data : weeklyData) {
            totalSteps += data.getSteps();
            totalSleep += data.getSleep();
            totalWater += data.getWaterIntake();
        }

        System.out.println("Weekly Summary:");
        System.out.println("Total Steps: " + totalSteps);
        System.out.println("Average Sleep: " + totalSleep / weeklyData.size() + " hours");
        System.out.println("Average Water Intake: " + totalWater / weeklyData.size() + " liters");
    }

    // Getters for goals
    public int getStepGoal() { return stepGoal; }
    public double getSleepGoal() { return sleepGoal; }
    public double getWaterGoal() { return waterGoal; }
    public String toString() {
        return name + " (" + age + " years, " + weight + " kg)";
    }
}
