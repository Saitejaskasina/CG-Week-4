import java.util.HashSet;
import java.util.Set;

class UserAlreadyExistsException extends Exception {
    UserAlreadyExistsException(String message) { super(message); }
}

class UserNotFoundException extends Exception {
    UserNotFoundException(String message) { super(message); }
}

public class UserService3 {
    private static final Set<String> users = new HashSet<>();

    static void registerUser(String username) throws UserAlreadyExistsException {
        if (users.contains(username)) {
            throw new UserAlreadyExistsException("User '" + username + "' already exists.");
        }
        users.add(username);
        System.out.println(username + " registered successfully.");
    }

    static void checkUserExistence(String username) throws UserNotFoundException {
        if (!users.contains(username)) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        System.out.println("User '" + username + "' exists.");
    }

    public static void main(String[] args) {
        try {
            registerUser("Alice");
            registerUser("Alice");
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkUserExistence("Bob");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}