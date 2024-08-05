import java.util.HashSet;
import java.util.Set;

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String str){
        super(str);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String str){
        super(str);
    }
}

class UserService {
    // Simulated user storage (you can replace this with a database or other data source)
    private final Set<String> registeredUsers = new HashSet<>();

    public void registerUser(String username) throws UserAlreadyExistsException {
        if (registeredUsers.contains(username)) {
            throw new UserAlreadyExistsException("User '" + username + "' already exists.");
        }
        registeredUsers.add(username);
        System.out.println("User '" + username + "' registered successfully!");
    }

    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!registeredUsers.contains(username)) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        System.out.println("User '" + username + "' exists.");
    }

    public static void main(String[] args) {
        UserService userService = new UserService();

        try {
            userService.registerUser("Alice");
            userService.checkUserExistence("Bob"); // Simulating a non-existent user
            userService.checkUserExistence("Alice"); // Simulating an existing user
        } catch (UserAlreadyExistsException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
