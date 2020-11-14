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

    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {

    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {

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
