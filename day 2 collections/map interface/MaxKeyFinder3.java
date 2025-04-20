import java.util.Map;

public class MaxKeyFinder3 {
    static <K> K findMaxKey(Map<K, Integer> map) {
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println(findMaxKey(map));
    }
}