import java.io.*;

public class CheckedException1 {
    public static void main(String[] args) {
        File file = new File("data.txt");

        if (!file.exists()) { // Check before attempting to read
            System.out.println("File not found");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}