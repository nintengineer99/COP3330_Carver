// library inclusions
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskItem {
    // task properties
    protected String title;
    protected String description;
    protected String date;
    protected LocalDate currentDate = java.time.LocalDate.now();
    protected boolean isComplete = false;

    // get and set methods for title
    protected String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        checkTitleValidity(title);
        this.title = title;
    }

    // get and set methods for description
    protected String getDesc() {
        return description;
    }

    protected void setDesc(String description) {
        this.description = description;
    }

    // retrieves local date from system's calendar
    protected LocalDate getUserDate(String userDate) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(userDate, dateFormat);
    }

    // get and set methods for description
    protected String getDueDate() {
        return date;
    }

    protected void setDueDate(String date) {
        checkDateValidity(date);
        this.date = date;
    }

    // returns *** if completed --- if not (for saving to file purposes)
    protected String isTaskComplete() {
        if (isComplete) {
            return "***";
        }
        else {
            return "---";
        }
    }

    // checks that the title is 1 character or longer
    protected void checkTitleValidity(String title) {
        if (title.equalsIgnoreCase("")) {
            throw new IllegalArgumentException();
        }
    }

    // checks that the due date is not in the past
    protected void checkDateValidity(String date) {
        if (currentDate.isAfter(getUserDate(date))) {
            throw new DateTimeException("WARNING: Invalid due date. Task not created/edited.");
        }
    }
}