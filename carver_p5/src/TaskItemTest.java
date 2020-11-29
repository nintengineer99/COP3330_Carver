// library inclusions
import org.junit.jupiter.api.Test;
import java.time.DateTimeException;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    // tests that taskItem created with an invalid due date throws a DateTimeException
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
    // tests that taskItem created with an invalid title throws a IllegalArgumentException
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
    // tests that taskItem created with a valid due date doesn't throw a DateTimeException
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    task.date = "9999-12-31";
                    task.checkDateValidity(task.date);
                }
        );
    }

    @Test
    // tests that taskItem created with an valid title doesn't throw an IllegalArgumentException
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    task.title = "E";
                    task.checkTitleValidity(task.title);
                }
        );
    }

    @Test
    // tests that setDueDate fails when an invalid date is passed
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
    // tests that setDueDate does not throw a DateTimeException when a valid date is passed
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        assertDoesNotThrow( () -> {
                    TaskItem task = new TaskItem();
                    String date = "9999-12-31";
                    task.setDueDate(date);
                }
        );
    }

    @Test
    // tests that setTitle fails when an invalid title is passed
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    TaskItem task = new TaskItem();
                    String title = "";
                    task.setTitle(title);
                }
        );
    }

    // tests that setTitle does not throw an exception when a valid title is passed
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