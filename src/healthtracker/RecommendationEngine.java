package healthtracker;
public class RecommendationEngine {
    public static void recommend(HealthData data, User user) {
        if (data.getSteps() < user.getStepGoal()) {
            System.out.println("Try to reach at least " + user.getStepGoal() + " steps.");
        } else {
            System.out.println("Good job on reaching your step goal!");
        }

        if (data.getSleep() < user.getSleepGoal()) {
            System.out.println("Aim for at least " + user.getSleepGoal() + " hours of sleep.");
        } else {
            System.out.println("You met your sleep goal!");
        }

        if (data.getWaterIntake() < user.getWaterGoal()) {
            System.out.println("Drink at least " + user.getWaterGoal() + " liters of water.");
        } else {
            System.out.println("Great hydration today!");
        }
    }
}


