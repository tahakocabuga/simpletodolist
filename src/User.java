public class User {
    private Tasker tasker;
    private String login;
    private String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    User(Tasker tasks) {
        this.tasker = tasks;
    }

    void addNewTask(String task) {
        tasker.createTask(task);
    }

    void deleteTask(String task) {
        tasker.deleteTask(task);
    }

    void showAllTasks() {
        tasker.showAllTasks();
    }

    String getPassword() {
        return password;
    }

}