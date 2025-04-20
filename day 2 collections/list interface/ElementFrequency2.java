import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementFrequency2 {
    static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apple", "orange");
        System.out.println(findFrequency(words));
    }
}
