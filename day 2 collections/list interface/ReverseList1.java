import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList1 {
    static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> linkedList = new LinkedList<>(arrayList);
        System.out.println(reverseList(arrayList));
        System.out.println(reverseList(linkedList));
    }
}