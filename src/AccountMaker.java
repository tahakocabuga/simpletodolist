import java.util.HashMap;
import java.util.Scanner;

public class AccountMaker {

    private HashMap<String, User> loginDetails = new HashMap<>();
    private String login, password;
    private Scanner input = new Scanner(System.in);


    void inputLoginAndPassword() {
        System.out.println("Input your login");
        login = input.next();

        System.out.println("Input your password");
        password = input.next();
    }

    void createAccount() throws InterruptedException {
        User newUser = new User(login, password);
        loginDetails.put(login, newUser);
        System.out.println("Account has been created successfully");
        Thread.sleep(2000);
    }

    HashMap<String, User> getLoginDetails() {
        return loginDetails;
    }

}