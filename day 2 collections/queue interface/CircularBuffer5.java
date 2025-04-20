import java.util.Arrays;

public class CircularBuffer5 {
    int[] buffer;
    int size, start = 0, end = 0;

    CircularBuffer5(int size) {
        this.size = size;
        buffer = new int[size];
    }

    void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % size;
        if (end == start) start = (start + 1) % size;
    }

    @Override public String toString() {
        return Arrays.toString(buffer);
    }

    public static void main(String[] args) {
        CircularBuffer5 buffer = new CircularBuffer5(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        System.out.println(buffer);
    }
}