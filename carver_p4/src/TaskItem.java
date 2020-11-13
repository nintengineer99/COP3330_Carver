import java.time.LocalDate;

public class TaskItem {
    protected String title;
    protected String description;
    protected LocalDate date;

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setDesc(String description) {
        this.description = description;
    }
}
