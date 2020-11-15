import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        Throwable exception = assertThrows(
                DateTimeException.class, () -> {
                    TaskItem task = new TaskItem();
                    task.date = "2000-12-31";
                    task.checkDateValidity(task.date);
                }
        );
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    TaskItem task = new TaskItem();
                    task.title = "";
                    task.checkTitleValidity(task.title);
                }
        );
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    task.date = "9999-12-31";
                    task.checkDateValidity(task.date);
                }
        );
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    task.title = "E";
                    task.checkTitleValidity(task.title);
                }
        );
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        Throwable exception = assertThrows(
                DateTimeException.class, () -> {
                    TaskItem task = new TaskItem();
                    String date = "2000-12-31";
                    task.setDueDate(date);
                }
        );
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    String date = "9999-12-31";
                    task.setDueDate(date);
                }
        );
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    TaskItem task = new TaskItem();
                    String title = "";
                    task.setTitle(title);
                }
        );
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    String title = "E";
                    task.setTitle(title);
                }
        );
    }
}
