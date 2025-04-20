import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;
    Patient(String name, int severity) { this.name = name; this.severity = severity; }
    @Override public String toString() { return name + " (" + severity + ")"; }
}

public class HospitalTriage3 {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.severity, a.severity));
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        while (!queue.isEmpty()) System.out.println(queue.poll());
    }
}