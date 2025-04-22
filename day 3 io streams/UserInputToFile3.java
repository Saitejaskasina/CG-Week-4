import java.io.*;

public class UserInputToFile3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("userinfo.txt")) {
            System.out.println("Enter name:");
            String name = reader.readLine();
            System.out.println("Enter age:");
            String age = reader.readLine();
            System.out.println("Enter favorite programming language:");
            String language = reader.readLine();

            writer.write("Name: " + name + "\nAge: " + age + "\nLanguage: " + language);
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}