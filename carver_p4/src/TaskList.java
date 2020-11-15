import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.lang.String;

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
            output.format("%s%n%d)%n[%s]%n%s%n%s%n", task.isTaskComplete(), i, task.getDueDate(), task.getTitle(), task.getDesc());
        }
        output.close();
    }

    protected void loadList(String fileName) throws IOException {
        try (Scanner file = new Scanner(Paths.get(fileName))) {
            while (file.hasNext()) {
                TaskItem loadedTask = new TaskItem();
                String isLoadedTaskComplete = file.nextLine();
                loadedTask.isComplete = isLoadedTaskComplete.contains("***");
                String ignoreIndex = file.nextLine();
                String loadedDueDate = file.nextLine().replace("[", "").replace("]","");
                String loadedTitle = file.nextLine();
                String loadedDesc = file.nextLine();
                loadedTask.setDueDate(loadedDueDate);
                loadedTask.setTitle(loadedTitle);
                loadedTask.setDesc(loadedDesc);
                addTask(loadedTask);
            }
        }
    }
}