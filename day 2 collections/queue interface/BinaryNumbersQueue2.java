
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersQueue2 {
    static String[] generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String binary = queue.poll();
            result[i] = binary;
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(generateBinaryNumbers(5)));
    }
}