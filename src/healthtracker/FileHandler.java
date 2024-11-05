package healthtracker;
import java.io.*;

public class FileHandler {
    private static final String FILE_NAME = "healthData.txt";

    public static void saveData(User user) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(user.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadData(User user) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // For now, just print data; can be parsed and loaded into user object
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

