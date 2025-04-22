import java.io.*;
import java.util.*;

public class WordCount10 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("textfile.txt"))) {
            Map<String, Integer> wordFrequency = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+")) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            wordFrequency.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(5)
                    .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}