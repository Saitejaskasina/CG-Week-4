import java.util.ArrayList;
import java.util.List;

public class RotateList3 {
    static <T> List<T> rotateList(List<T> list, int positions) {
        List<T> rotated = new ArrayList<>(list.subList(positions, list.size()));
        rotated.addAll(list.subList(0, positions));
        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        System.out.println(rotateList(numbers, 2));
    }
}