import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class ReverseQueue1 {
    static <T> Queue<T> reverseQueue(Queue<T> queue) {
        LinkedList<T> stack = new LinkedList<>();
        while (!queue.isEmpty()) stack.push(queue.poll());
        while (!stack.isEmpty()) queue.offer(stack.pop());
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(List.of(10, 20, 30));
        System.out.println(reverseQueue(queue)); // Output: [30, 20, 10]
    }
}
