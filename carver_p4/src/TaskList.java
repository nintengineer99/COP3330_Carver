import java.util.ArrayList;

public class TaskList {
    int taskCount = 0;

    ArrayList<TaskItem> tasks = new ArrayList<>();

    protected void addTask(TaskItem task) {
        tasks.add(task);
        taskCount++;
    }

    protected TaskItem getTask(int index) {
        return tasks.get(index);
    }
}