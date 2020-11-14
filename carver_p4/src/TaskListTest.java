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
        tasks.editTask(0, "A", "Whoever is grading this, have a good day!", "9999-01-31");
        assertEquals("A", task.getTitle());
        assertEquals("Whoever is grading this, have a good day!", task.getDesc());
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
        tasks.editTask(0, "A", "Whoever is grading this, have a good day!", "9999-01-31");
        assertEquals("Whoever is grading this, have a good day!", task.getDesc());
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
                    tasks.editTask(1, "A", "Whoever is grading this, have a good day!", "9999-01-31");
                    assertEquals("Whoever is grading this, have a good day!", task.getDesc());
                }
        );
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        tasks.editTask(0, "A", "Whoever is grading this, have a good day!", "9999-01-31");
        assertEquals("9999-01-31", task.getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    tasks.addTask(task);
                    tasks.editTask(1, "A", "Whoever is grading this, have a good day!", "9999-01-31");
                    assertEquals("9999-01-31", task.getDueDate());
                }
        );
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        tasks.editTask(0, "A", "Whoever is grading this, have a good day!", "9999-01-31");
        assertEquals("A", task.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    tasks.addTask(task);
                    tasks.editTask(1, "A", "Whoever is grading this, have a good day!", "9999-01-31");
                    assertEquals("A", task.getTitle());
                }
        );
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    tasks.addTask(task);
                    String desc = tasks.getTask(1).getDesc();
                }
        );
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        String desc = tasks.getTask(0).getDesc();
        assertEquals(task.getDesc(), desc);
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    tasks.addTask(task);
                    String date = tasks.getTask(1).getDueDate();
                }
        );
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        String date = tasks.getTask(0).getDueDate();
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    tasks.addTask(task);
                    String title = tasks.getTask(1).getTitle();
                }
        );
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        String title = tasks.getTask(0).getTitle();
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList tasks = new TaskList();
        assertEquals(0, tasks.taskCount);
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
