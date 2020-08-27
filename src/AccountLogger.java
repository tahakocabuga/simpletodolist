import java.util.Scanner;

public class AccountLogger {

    private AccountMaker accountMaker;
    private Scanner input = new Scanner(System.in);
    private String login, password;


    AccountLogger(AccountMaker accountMaker) {
        this.accountMaker = accountMaker;
    }


    void inputLoginAndPassword() {
        System.out.println("Input your login");
        login = input.next();

        System.out.println("Input your password");
        password = input.next();
    }

    boolean isLoginDataIncorrect() {
        User user = accountMaker.getLoginDetails().get(login);
        try {
            if (user.getPassword().equals(password)) {
                System.out.println("You've logged in.");
                return false;
            } else {
                System.out.println("Bad login or password");
            }
        } catch (NullPointerException e) {
            System.out.println("Bad login or password");
        }
        return true;
    }
}