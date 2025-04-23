class DatabaseConnection implements AutoCloseable {
    void connect() { System.out.println("Connected to database."); }
    @Override public void close() { System.out.println("Database connection closed."); }
}

public class ResourceCleanup7 {
    public static void main(String[] args) {
        try (DatabaseConnection db = new DatabaseConnection()) {
            db.connect();
            throw new RuntimeException("Unexpected database failure.");
        } catch (Exception e) {
            System.out.println("Handled exception: " + e.getMessage());
        }
    }
}