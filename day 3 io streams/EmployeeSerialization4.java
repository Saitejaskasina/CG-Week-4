import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override public String toString() {
        return id + " | " + name + " | " + department + " | Salary: " + salary;
    }
}

public class EmployeeSerialization4 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee(1, "Alice", "HR", 50000),
                                           new Employee(2, "Bob", "IT", 60000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized.");

            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            deserializedEmployees.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}