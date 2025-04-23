import java.io.*;
import java.util.List;

public class FileProcessor1 {
    public static void processFiles(List<String> filePaths) {
        for (String path : filePaths) {
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("File not found: " + path);
                continue;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + path);
            }
        }
    }

    public static void main(String[] args) {
        processFiles(List.of("file1.txt", "file2.txt", "file3.txt"));
    }
}