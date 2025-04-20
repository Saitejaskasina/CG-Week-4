import java.util.LinkedList;
import java.util.List;

public class FindNthFromEnd5 {
    static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        var slow = list.listIterator();
        var fast = list.listIterator();
        
        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) fast.next();
            else return null;
        }
        
        while (fast.hasNext()) {
            slow.next();
            fast.next();
        }
        
        return slow.next();
    }
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(List.of("A", "B", "C", "D", "E"));
        System.out.println(findNthFromEnd(list, 2));
    }
}
