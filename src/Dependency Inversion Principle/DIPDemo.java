
import java.util.ArrayList;
import java.util.List;

public class DIPDemo {
    public static void main(String[] args) {
        System.out.println("===== Configuration 1: MySQL + Email + Console =====\n");
        UserService service1 = ServiceFactory.createUserService("mysql", "email", "console");
        service1.registerUser("john_doe", "john@example.com");

        System.out.println("\n===== Configuration 2: MongoDB + SMS + File =====\n");
        UserService service2 = ServiceFactory.createUserService("mongodb", "sms", "file");
        service2.registerUser("jane_smith", "jane@example.com");

        System.out.println("\n===== Easy to switch implementations =====\n");
        service1.retrieveUser("12345");
        service2.retrieveUser("67890");
    }
}