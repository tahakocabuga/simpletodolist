import java.util.ArrayList;
import java.util.List;

public class Tasker {

    private List<String> listOfTasks = new ArrayList<>();


    void createTask(String task) {
        listOfTasks.add(task);
    }

    void deleteTask(String task) {
        listOfTasks.remove(task);
    }

    void showAllTasks() {
        for (String listOfTask : listOfTasks) {
            System.out.println(listOfTask);
        }
    }
}