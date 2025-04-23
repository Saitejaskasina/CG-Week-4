class TransactionException extends Exception {
    TransactionException(String message) { super(message); }
}

public class TransactionHandler5 {
    static void processTransaction(double amount) throws TransactionException {
        try {
            if (amount <= 0) throw new IllegalArgumentException("Invalid amount.");
        } catch (IllegalArgumentException e) {
            throw new TransactionException("Transaction error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            processTransaction(-50);
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
        }
    }
}