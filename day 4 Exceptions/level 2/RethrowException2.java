public class RethrowException2 {
    static int performDivision(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return numerator / denominator;
    }

    static int calculate(int numerator, int denominator) throws ArithmeticException {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error in calculation: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Result: " + calculate(10, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}