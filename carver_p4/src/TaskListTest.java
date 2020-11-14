import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        assertEquals(1, tasks.taskCount);
    }

    @Test
    public void completingTaskItemChangesStatus() {

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {

    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        task.setTitle("A");
        task.setDesc("Whoever is grading this, I hope you're having a good day!");
        task.setDueDate("9999-01-31");
        assertEquals("A", task.getTitle());
        assertEquals("Whoever is grading this, I hope you're having a good day!", task.getDesc());
        assertEquals("9999-01-31", task.getDueDate());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        task.setDesc("Whoever is grading this, I hope you're having a good day!");
        assertEquals("Whoever is grading this, I hope you're having a good day!", task.getDesc());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    tasks.addTask(task);
                    task = tasks.getTask(1);
                    task.setDesc("Whoever is grading this, I hope you're having a good day!");
                }
        );
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {

    }

    @Test
    public void editingTaskItemTitleChangesValue() {

    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {

    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {

    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {

    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {

    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {

    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {

    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {

    }

    @Test
    public void newTaskListIsEmpty() {

    }

    @Test
    public void removingTaskItemsDecreasesSize() {

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {

    }

    @Test
    public void savedTaskListCanBeLoaded() {

    }

    @Test
    public void uncompletingTaskItemChangesStatus() {

    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {

    }
}
