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

    protected void editTask(int index, String newTitle, String newDesc, String newDate) {
        if (index < 0 || index > taskCount) {
            throw new IndexOutOfBoundsException();
        }
        TaskItem editedTask = getTask(index);
        editedTask.setTitle(newTitle);
        editedTask.setDesc(newDesc);
        editedTask.setDueDate(newDate);
    }
}