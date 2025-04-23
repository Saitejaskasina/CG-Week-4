public class ThrowVsThrows6 {
    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        return amount * Math.pow(1 + (rate / 100), years);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Calculated interest: " + calculateInterest(1000, 5, 3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}