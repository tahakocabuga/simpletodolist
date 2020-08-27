import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoEngine {

    private Scanner input = new Scanner(System.in);
    private AccountMaker accountMaker = new AccountMaker();
    private AccountLogger accountLogger = new AccountLogger(accountMaker);
    private boolean loopIsTrue = true;
    private Tasker tasks = new Tasker();
    private User user = new User(tasks);

    void displayMainMenu() {
        System.out.println("What do you wanna to do?");
        System.out.println("1. Add Account 2. Log into my account");

        while (loopIsTrue) {
            try {
                getOptionsOfMainMenu(input.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("You've inputed something wrong!");
                System.out.println("What do you wanna to do?");
                System.out.println("1. Add Account 2. Log into my account");
                input.next();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getOptionsOfMainMenu(int option) throws InterruptedException {
        if (option >= 1 && option <= 2) {
            switch (option) {
                case 1:
                    accountMaker.inputLoginAndPassword();
                    accountMaker.createAccount();
                    System.out.println("Now let's log into you account.");
                case 2:
                    while (loopIsTrue) {
                        accountLogger.inputLoginAndPassword();
                        if (!accountLogger.isLoginDataIncorrect()) {
                            loopIsTrue = false;
                        }
                    }
                    break;
            }
        }
    }

    public void displayUserMenu() {
        loopIsTrue = true;
        while (loopIsTrue) {
            System.out.println("What do you wanna to do?");
            System.out.println("1. Add task 2. Show my tasks 3. Delete task 4. Exit");
            getOptionsOfUserMenu(input.nextInt());
        }
    }

    private void getOptionsOfUserMenu(int option) {
        if (option >= 1 && option <= 4) {
            switch (option) {
                case 1:
                    System.out.println("Write down your task.");
                    input.nextLine();
                    user.addNewTask(input.nextLine());
                    System.out.println("Task was added.");
                    break;
                case 2:
                    System.out.println("----------------");
                    System.out.println("YOUR TASK LIST:");
                    user.showAllTasks();
                    System.out.println("----------------");
                    break;
                case 3:
                    System.out.println("Write down your task that you want to delete from task list.");
                    input.nextLine();
                    user.deleteTask(input.nextLine());
                    System.out.println("Task was deleted");
                    loopIsTrue = false;
                    break;
                case 4:
                    loopIsTrue = false;
                    break;
            }
        }
    }
}