// library inclusions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    // tests that taskCount properly increments
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
    // tests that marking off a task changes its isComplete status to true
    public void completingTaskItemChangesStatus() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        tasks.markOffTask(0);
        assertTrue(task.isComplete);
    }

    @Test
    // tests that markOffTask will fail when passed an invalid index
    public void completingTaskItemFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    tasks.addTask(task);
                    tasks.markOffTask(1);
                }
        );
    }

    @Test
    // tests that changes to a preexisting task's properties actually take effect
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
    // tests that changing a preexisting task's description actually takes effect
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
    // tests that changing a preexisting task's description fails when passed an invalid index
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
    // tests that changing a preexisting task's due date actually takes effect
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
    // tests that changing a preexisting task's due date doesn't take effect when passed an invalid task
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
    // tests that changing a preexisting task's title actually takes effect
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
    // tests that changing a preexisting task's title doesn't take effect when passed an invalid task
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
    // tests that a description can be properly received when passing a valid task index
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
    // tests that a description cannot be properly received when passing an invalid task index
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
    // tests that a due date can be properly received when passing a valid task index
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        String date = tasks.getTask(0).getDueDate();
        assertEquals("9999-12-31", date);
    }

    @Test
    // tests that a due date cannot be properly received when passing an invalid task index
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
        assertEquals("E", title);
    }

    @Test
    // tests that a new task list has no tasks when created
    public void newTaskListIsEmpty() {
        TaskList tasks = new TaskList();
        assertEquals(0, tasks.taskCount);
    }

    @Test
    // tests that the removeTask method decrements
    public void removingTaskItemsDecreasesSize() {TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        tasks.addTask(task);
        tasks.removeTask(0);
        assertEquals(0, tasks.taskCount);
    }

    @Test
    // tests that the removeTask method decrements
    public void removingTaskItemsFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    tasks.addTask(task);
                    tasks.removeTask(1);
                }
        );
    }

    @Test
    // checks that no exceptions are thrown when loading
    public void savedTaskListCanBeLoaded() {
        assertDoesNotThrow( () -> {
            TaskList tasks = new TaskList();
            tasks.loadList("tasks.txt");
        }
        );
    }

    @Test
    // tests that the unmarkTask method sets a task's isComplete property to false
    public void uncompletingTaskItemChangesStatus() {
        TaskList tasks = new TaskList();
        TaskItem task = new TaskItem();
        task.setTitle("E");
        task.setDesc("This is a description.");
        task.setDueDate("9999-12-31");
        task.isComplete = true;
        tasks.addTask(task);
        tasks.unmarkTask(0);
        assertFalse(task.isComplete);
    }

    @Test
    // tests that the unmarkTask method fails when passed an invalid index
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    TaskList tasks = new TaskList();
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                    task.setDesc("This is a description.");
                    task.setDueDate("9999-12-31");
                    task.isComplete = true;
                    tasks.addTask(task);
                    tasks.unmarkTask(1);
                }
        );
    }
}
