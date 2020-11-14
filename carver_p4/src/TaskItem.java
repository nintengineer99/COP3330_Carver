import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class TaskItem implements Serializable {
    protected String title;
    protected String description;
    protected String date;
    protected LocalDate currentDate = java.time.LocalDate.now();
    protected boolean isComplete = false;

    protected String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        if (title.equalsIgnoreCase("")) {
                throw new IllegalArgumentException();
        }
        this.title = title;
    }

    protected String getDesc() {
        return description;
    }

    protected void setDesc(String description) {
        this.description = description;
    }

    protected LocalDate getUserDate(String userDate) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(userDate, dateFormat);
        return date;
    }

    protected String getDueDate() {
        return date;
    }

    protected void setDueDate(String date) {
        if (currentDate.isAfter(getUserDate(date))) {
            throw new DateTimeException("WARNING: Invalid due date. Task not created");
        }
        this.date = date;
    }
}
