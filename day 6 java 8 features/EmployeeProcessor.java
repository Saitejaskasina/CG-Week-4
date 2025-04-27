import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() { // Added getter method
        return salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - $" + salary;
    }
}

public class EmployeeProcessor {
    public static void processEmployees(List<Employee> employees) {
        Map<String, Double> avgSalaryByDept = employees.stream()
            .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.groupingBy(e -> e.department,
                Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryByDept);
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Alice", "Engineering", 90000),
            new Employee(2, "Bob", "Engineering", 85000),
            new Employee(3, "Charlie", "HR", 75000)
        );

        processEmployees(employees);
    }
}