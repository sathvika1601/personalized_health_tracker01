package healthtracker;
public class HealthData {
    private int steps;
    private double sleep;
    private double waterIntake;

    public HealthData(int steps, double sleep, double waterIntake) {
        this.steps = steps;
        this.sleep = sleep;
        this.waterIntake = waterIntake;
    }

    public int getSteps() {
        return steps;
    }

    public double getSleep() {
        return sleep;
    }

    public double getWaterIntake() {
        return waterIntake;
    }

    @Override
    public String toString() {
        return "HealthData{" +
                "steps=" + steps +
                ", sleep=" + sleep +
                ", waterIntake=" + waterIntake +
                '}';
    }
}
