import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItem {
    // Use Ctrl + Shift + F10 to format your code. Remember to use Fn on your laptop to make F10 work properly.
    /*  https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html  */
    private String title;
    private String description;
    private LocalDate dueDate;

    public TaskItem() {
    } //Empty Constructor

    public TaskItem(String inputTitle, String inputDescription, String inputDueDate) {
        checkAndReadInTitle(inputTitle);
        checkAndReadInDescription(inputDescription);
        checkAndReadInDueDate(inputDueDate);
    }

    private void checkAndReadInTitle(String inputTitle) {
        //A title shall be 1 or more characters in length
        if (inputTitle.length() > 0) {
            this.title = inputTitle;
        } else {
            throw new IllegalArgumentException("Titles should be 1 or more characters in length");
        }
    }

    private void checkAndReadInDescription(String inputDescription) {
        //A description shall be 0 or more characters in length
        this.description = inputDescription;
    }

    private void checkAndReadInDueDate(String inputDueDate) {
        //A due date shall be in the format of YYYY-MM-DD
        try {
            this.dueDate = LocalDate.parse(inputDueDate);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Due dates should be in YYYY-MM-DD format");
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDueDate() {
        return this.dueDate.toString();
    }
}