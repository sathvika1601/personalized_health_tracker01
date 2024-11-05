package healthtracker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthTrackerApp extends JFrame {
    private User user;
    private JTextField stepsField, sleepField, waterField;

    public HealthTrackerApp(User user) {
        this.user = user;

        setTitle("Personalized Health Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for input fields
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Steps:"));
        stepsField = new JTextField();
        panel.add(stepsField);

        panel.add(new JLabel("Sleep (hrs):"));
        sleepField = new JTextField();
        panel.add(sleepField);

        panel.add(new JLabel("Water (L):"));
        waterField = new JTextField();
        panel.add(waterField);

        JButton addButton = new JButton("Add Health Data");
        addButton.addActionListener(new AddHealthDataListener());
        panel.add(addButton);

        JButton summaryButton = new JButton("View Weekly Summary");
        summaryButton.addActionListener(new SummaryListener());
        panel.add(summaryButton);

        add(panel, BorderLayout.CENTER);
    }

    // Event listener for adding daily health data
    private class AddHealthDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int steps = Integer.parseInt(stepsField.getText());
            double sleep = Double.parseDouble(sleepField.getText());
            double water = Double.parseDouble(waterField.getText());

            HealthData data = new HealthData(steps, sleep, water);
            user.addHealthData(data);

            JOptionPane.showMessageDialog(null, "Data added for today!");
            RecommendationEngine.recommend(data,user);

            // Clear fields
            stepsField.setText("");
            sleepField.setText("");
            waterField.setText("");
        }
    }

    // Event listener to show weekly summary
    private class SummaryListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            user.printWeeklySummary();
        }
    }

    public static void main(String[] args) {
        User user = new User("Sathvika", 21, 50); // Replace with actual user details
        new HealthTrackerApp(user).setVisible(true);
    }
}

