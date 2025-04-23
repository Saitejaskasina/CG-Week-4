import java.util.Scanner;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) { 
        super(message); 
    }
}

public class CustomException3 {
    static void validateAge(int age) throws InvalidAgeException { // Explicitly declares throws
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {  // Handles unexpected errors
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close(); // Ensures the scanner is closed properly
        }
    }
}