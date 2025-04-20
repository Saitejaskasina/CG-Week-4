import java.io.*;
import java.util.*;

public class WordFrequencyCounter1 {
    static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordMap = new HashMap<>();
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        for (String word : text.split("\\s+")) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        return wordMap;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        System.out.println(countWords(input));
    }
}