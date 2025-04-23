class DataProcessingException extends Exception {
    DataProcessingException(String message) { super(message); }
}

public class ExceptionHandling6 {
    static void processData(String data) throws DataProcessingException {
        if (data == null) throw new DataProcessingException("Data cannot be null.");
        if (data.isEmpty()) throw new RuntimeException("Data cannot be empty.");
        System.out.println("Processed: " + data);
    }

    public static void main(String[] args) {
        try {
            processData("");
        } catch (DataProcessingException e) {
            System.out.println("Checked Exception: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unchecked Exception: " + e.getMessage());
        }
    }
}