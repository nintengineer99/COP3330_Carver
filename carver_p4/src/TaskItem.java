import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskItem {
    protected String title;
    protected String description;
    protected String date;
    protected LocalDate currentDate = java.time.LocalDate.now();

    public TaskItem(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    protected void setTitle(String title) {
        try {
            if (title.equalsIgnoreCase("")) {
                throw new IllegalArgumentException();
            }
            this.title = title;
        }
        catch(IllegalArgumentException e) {
            System.out.println("WARNING: Title must contain at least 1 character.");
        }
    }

    protected void setDesc(String description) {
        this.description = description;
    }

    protected LocalDate getUserDate(String userDate) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(userDate, dateFormat);
        return date;
    }

    protected void setDueDate(String date) {
        try {
            if (currentDate.isAfter(getUserDate(date))) {
                throw new IllegalArgumentException();
            }
            this.date = date;
        }
        catch (IllegalArgumentException e) {
            System.out.println("WARNING: Your due date must be either on or after today's date.");
        }
    }
}
