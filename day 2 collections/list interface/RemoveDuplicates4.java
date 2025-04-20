import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates4 {
    static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> uniqueSet = new LinkedHashSet<>(list);
        return List.copyOf(uniqueSet);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 1, 2, 2, 3, 4);
        System.out.println(removeDuplicates(numbers));
    }
}