import java.util.ArrayList;

public class TaskList {
    ArrayList<TaskItem> tasks = new ArrayList<>();
    protected void addTask(TaskItem task) {
        tasks.add(task);
    }
}