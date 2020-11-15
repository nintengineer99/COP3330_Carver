// library inclusions
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.lang.String;

public class TaskList {
    // counter to track how many tasks currently exist
    int taskCount = 0;

    // taskList utilizes behaviors of an arraylist for application's purposes
    ArrayList<TaskItem> tasks = new ArrayList<>();

    // retrieves task's index when needed
    protected int getTaskIndex(TaskItem task) {
        return tasks.indexOf(task);
    }

    // adds passed task to arraylist and increases task count by 1
    protected void addTask(TaskItem task) {
        tasks.add(task);
        taskCount++;
    }

    // retrieves a specific task when necessary
    protected TaskItem getTask(int index) {
        return tasks.get(index);
    }

    // retrieves a specific task and changes its properties
    protected void editTask(int index, String newTitle, String newDesc, String newDate) {
        if (index < 0 || index > taskCount) {
            throw new IndexOutOfBoundsException();
        }
        TaskItem editedTask = getTask(index);
        editedTask.setTitle(newTitle);
        editedTask.setDesc(newDesc);
        editedTask.setDueDate(newDate);
    }

    // removes a specified task and decreases task count by 1
    protected void removeTask(int index) {
        if (index < 0 || index > taskCount) {
            throw new IndexOutOfBoundsException();
        }
        tasks.remove(index);
        taskCount--;
    }

    // changes specified task's isComplete property to true
    protected void markOffTask(int index) {
        if (index < 0 || index > taskCount) {
            throw new IndexOutOfBoundsException();
        }
        getTask(index).isComplete = true;
    }

    // changes specified task's isComplete property to false
    protected void unmarkTask(int index) {
        if (index < 0 || index > taskCount) {
            throw new IndexOutOfBoundsException();
        }
        getTask(index).isComplete = false;
    }

    // saves a list by writing it to a text file for later use
    protected void saveList(String fileName) throws FileNotFoundException {
        Formatter output = new Formatter(fileName);
        for(int i = 0; i < taskCount; i++) {
            TaskItem task = getTask(i);
            output.format("%s%n%d)%n[%s]%n%s%n%s%n", task.isTaskComplete(), i, task.getDueDate(), task.getTitle(), task.getDesc());
        }
        output.close();
    }

    // loads in a list for further work
    protected void loadList(String fileName) throws IOException {
        try (Scanner file = new Scanner(Paths.get(fileName))) {
            while (file.hasNext()) {
                TaskItem loadedTask = new TaskItem();
                String isLoadedTaskComplete = file.nextLine();
                loadedTask.isComplete = isLoadedTaskComplete.contains("***");
                String ignoreIndex = file.nextLine(); // needed to prevent loading in task index as a date, title, or description
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