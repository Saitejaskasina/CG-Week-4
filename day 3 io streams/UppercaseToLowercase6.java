import java.io.*;

public class UppercaseToLowercase6 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("uppercase.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("lowercase.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase() + "\n");
            }
            System.out.println("File converted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}