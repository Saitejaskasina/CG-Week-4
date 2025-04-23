import java.io.*;

public class MultiFileProcessor4 {
    public static void processFiles(String inputFile1, String inputFile2, String outputFile) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
             BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            while ((line = reader1.readLine()) != null) writer.write(line + "\n");
            while ((line = reader2.readLine()) != null) writer.write(line + "\n");

            System.out.println("Merged files into " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        processFiles("file1.txt", "file2.txt", "output.txt");
    }
}