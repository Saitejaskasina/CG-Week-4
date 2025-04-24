import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.*;
import java.util.*;

class Calculator {
    int add(int a, int b) { return a + b; }
    int subtract(int a, int b) { return a - b; }
    int multiply(int a, int b) { return a * b; }
    int divide(int a, int b) { if (b == 0) throw new ArithmeticException("Cannot divide by zero"); return a / b; }
}

class StringUtils {
    String reverse(String str) { return new StringBuilder(str).reverse().toString(); }
    boolean isPalindrome(String str) { return str.equals(reverse(str)); }
    String toUpperCase(String str) { return str.toUpperCase(); }
}

class ListManager {
    void addElement(List<Integer> list, int element) { list.add(element); }
    void removeElement(List<Integer> list, int element) { list.remove(Integer.valueOf(element)); }
    int getSize(List<Integer> list) { return list.size(); }
}

class DatabaseConnection {
    void connect() { System.out.println("Connected to DB"); }
    void disconnect() { System.out.println("Disconnected from DB"); }
}

class FileProcessor {
    void writeToFile(String filename, String content) throws IOException { try (FileWriter fw = new FileWriter(filename)) { fw.write(content); } }
    String readFromFile(String filename) throws IOException { return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filename))); }
}

class Utils {
    boolean isEven(int number) { return number % 2 == 0; }
    void longRunningTask() throws InterruptedException { Thread.sleep(3000); }
}

public class JUnitTestCases {
    Calculator calc;
    StringUtils strUtils;
    ListManager listManager;
    DatabaseConnection db;
    FileProcessor fileProcessor;
    Utils utils;

    @BeforeEach
    void setup() {
        calc = new Calculator();
        strUtils = new StringUtils();
        listManager = new ListManager();
        db = new DatabaseConnection();
        fileProcessor = new FileProcessor();
        utils = new Utils();
        db.connect();
    }

    @AfterEach
    void cleanup() { db.disconnect(); }

    @Test
    void testCalculator() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(-1, calc.subtract(2, 3));
        assertEquals(6, calc.multiply(2, 3));
        assertThrows(ArithmeticException.class, () -> calc.divide(2, 0));
    }

    @Test
    void testStringUtils() {
        assertEquals("olleh", strUtils.reverse("hello"));
        assertTrue(strUtils.isPalindrome("madam"));
        assertEquals("HELLO", strUtils.toUpperCase("hello"));
    }

    @Test
    void testListManager() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        assertTrue(list.contains(5));
        listManager.removeElement(list, 5);
        assertFalse(list.contains(5));
        assertEquals(0, listManager.getSize(list));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    void testIsEven(int number) {
        assertEquals(number % 2 == 0, utils.isEven(number));
    }

    @Test
    @Timeout(2)
    void testTimeout() { assertThrows(InterruptedException.class, () -> utils.longRunningTask()); }

    @Test
    void testFileProcessor() throws IOException {
        String filename = "test.txt";
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(filename, content);
        assertEquals(content, fileProcessor.readFromFile(filename));
        assertTrue(new File(filename).exists());
    }
}