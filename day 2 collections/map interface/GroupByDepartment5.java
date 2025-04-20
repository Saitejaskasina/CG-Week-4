import java.util.*;

class Employee {
    String name, department;
    Employee(String name, String department) { this.name = name; this.department = department; }
    @Override public String toString() { return name; }
}

public class GroupByDepartment5 {
    static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee e : employees) {
            grouped.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }
        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee("Alice", "HR"), new Employee("Bob", "IT"), new Employee("Carol", "HR"));
        System.out.println(groupByDepartment(employees));
    }
}
