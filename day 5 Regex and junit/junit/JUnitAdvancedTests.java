
// JUnit Test Cases
public class JUnitAdvancedTests {

    @Test
    void testBankAccount() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
        account.withdraw(40);
        assertEquals(110, account.getBalance());
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }

    @Test
    void testPasswordValidator() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.isValid("StrongPass1"));
        assertFalse(validator.isValid("weakpass"));
    }

    @Test
    void testTemperatureConverter() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(32.0, converter.celsiusToFahrenheit(0));
        assertEquals(100.0, converter.celsiusToFahrenheit(37.78), 0.01);
        assertEquals(0.0, converter.fahrenheitToCelsius(32));
        assertEquals(37.78, converter.fahrenheitToCelsius(100), 0.01);
    }

    @Test
    void testDateFormatter() throws ParseException {
        DateFormatter formatter = new DateFormatter();
        assertEquals("12-05-2025", formatter.formatDate("2025-05-12"));
        assertEquals("01-01-2020", formatter.formatDate("2020-01-01"));
    }

    @Test
    void testUserRegistration() {
        UserRegistration registration = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "test@example.com", "password123"));
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("user", "", "password123"));
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("user", "test@example.com", ""));
    }
}