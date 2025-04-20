import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues4 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) q2.add(q1.poll());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    int pop() { return q1.poll(); }

    int top() { return q1.peek(); }

    public static void main(String[] args) {
        StackUsingQueues4 stack = new StackUsingQueues4();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
    }
}