import java.util.Set;

public class CheckSubset5 {
    static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(2, 3);
        Set<Integer> set2 = Set.of(1, 2, 3, 4);
        System.out.println(isSubset(set1, set2));
    }
}