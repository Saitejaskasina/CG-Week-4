import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ConvertSetToSortedList4 {
    static List<Integer> convertToSortedList(Set<Integer> set) {
        return new ArrayList<>(new TreeSet<>(set));
    }

    public static void main(String[] args) {
        Set<Integer> set = Set.of(5, 3, 9, 1);
        System.out.println(convertToSortedList(set));
    }
}