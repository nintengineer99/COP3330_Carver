import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class TaskList {
    int taskCount = 0;

    ArrayList<TaskItem> tasks = new ArrayList<>();

    protected int getTaskIndex(TaskItem task) {
        return tasks.indexOf(task);
    }

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

    protected void removeTask(int index) {
        if (index < 0 || index > taskCount) {
            throw new IndexOutOfBoundsException();
        }
        tasks.remove(index);
        taskCount--;
    }

    protected void markOffTask(int index) {
        if (index < 0 || index > taskCount) {
            throw new IndexOutOfBoundsException();
        }
        getTask(index).isComplete = true;
    }

    protected void unmarkTask(int index) {
        if (index < 0 || index > taskCount) {
            throw new IndexOutOfBoundsException();
        }
        getTask(index).isComplete = false;
    }

    protected void saveList(String fileName) throws FileNotFoundException {
        Formatter output = new Formatter(fileName);
        for(int i = 0; i < taskCount; i++) {
            TaskItem task = getTask(i);
            if(!task.isComplete) {
                output.format("%d) [%s] %s: %s%n", i, task.getDueDate(), task.getTitle(), task.getDesc());

            }
            else {
                output.format("*** %d) [%s] %s: %s%n", i, task.getDueDate(), task.getTitle(), task.getDesc());
            }
        }
        output.close();
    }
}