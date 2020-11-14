import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        Throwable exception = assertThrows(
                DateTimeException.class, () -> {
                    TaskItem task = new TaskItem();
                    task.setDueDate("1000-01-01");
                }
        );
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    TaskItem task = new TaskItem();
                    task.setTitle("");
                }
        );
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    task.setDueDate("9999-12-31");
                }
        );
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    task.setTitle("E");
                }
        );
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {

    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {

    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {

    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {

    }
}
