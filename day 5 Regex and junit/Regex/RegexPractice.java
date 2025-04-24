import java.util.regex.*;
import java.util.*;

public class RegexPractice {

    // 1. Validate Username
    public static boolean validateUsername(String username) {
        return username.matches("^[a-zA-Z]\\w{4,14}$");
    }

    // 2. Validate License Plate
    public static boolean validateLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    // 3. Validate Hex Color Code
    public static boolean validateHexColor(String color) {
        return color.matches("^#([a-fA-F0-9]{6})$");
    }

    // 4. Extract Email Addresses
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Matcher matcher = Pattern.compile("[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}").matcher(text);
        while (matcher.find()) emails.add(matcher.group());
        return emails;
    }

    // 5. Extract Capitalized Words
    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(text);
        while (matcher.find()) words.add(matcher.group());
        return words;
    }

    // 6. Extract Dates in dd/mm/yyyy Format
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        while (matcher.find()) dates.add(matcher.group());
        return dates;
    }

    // 7. Extract Links from a Web Page
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile("https?://\\S+").matcher(text);
        while (matcher.find()) links.add(matcher.group());
        return links;
    }

    // 8. Replace Multiple Spaces with a Single Space
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    // 9. Censor Bad Words
    public static String censorBadWords(String text, List<String> badWords) {
        for (String word : badWords) text = text.replaceAll("(?i)" + word, "****");
        return text;
    }

    // 10. Validate IPv4 Address
    public static boolean validateIPv4(String ip) {
        return ip.matches("^(\\d{1,3}\\.){3}\\d{1,3}$");
    }

    // 11. Validate Credit Card Number
    public static boolean validateCreditCard(String card) {
        return card.matches("^(4|5)\\d{15}$");
    }

    // 12. Extract Programming Language Names
    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);
        while (matcher.find()) languages.add(matcher.group());
        return languages;
    }

    // 13. Extract Currency Values
    public static List<String> extractCurrencyValues(String text) {
        List<String> values = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\$?\\d+(\\.\\d{2})?").matcher(text);
        while (matcher.find()) values.add(matcher.group());
        return values;
    }

    // 14. Find Repeating Words
    public static List<String> findRepeatingWords(String text) {
        List<String> repeated = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b(?=.*\\b\\1\\b)").matcher(text);
        while (matcher.find()) repeated.add(matcher.group());
        return repeated;
    }

    // 15. Validate SSN
    public static boolean validateSSN(String ssn) {
        return ssn.matches("\\d{3}-\\d{2}-\\d{4}");
    }

    public static void main(String[] args) {
        // Example usage:
        System.out.println(validateUsername("user_123"));  // true
        System.out.println(validateLicensePlate("AB1234"));  // true
        System.out.println(validateHexColor("#FFA500"));  // true
        System.out.println(extractEmails("Contact us at support@example.com and info@company.org"));
        System.out.println(extractCapitalizedWords("The Eiffel Tower is in Paris and the Statue of Liberty is in New York."));
        System.out.println(extractDates("The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020."));
        System.out.println(extractLinks("Visit https://www.google.com and http://example.org for more info."));
        System.out.println(normalizeSpaces("This    is  an example    with multiple spaces."));
        System.out.println(censorBadWords("This is a damn bad example with some stupid words.", Arrays.asList("damn", "stupid")));
        System.out.println(validateIPv4("192.168.1.1"));  // true
        System.out.println(validateCreditCard("4111111111111111"));  // true
        System.out.println(extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
        System.out.println(extractCurrencyValues("The price is $45.99, and the discount is 10.50."));
        System.out.println(findRepeatingWords("This is is a repeated repeated word test."));
        System.out.println(validateSSN("123-45-6789"));  // true
    }
}