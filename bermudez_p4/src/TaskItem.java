import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItem {
    // Use Ctrl + Shift + F10 to format your code. Remember to use Fn on your laptop to make F10 work properly.
    /*  https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html  */
    private String title;
    private String description;
    private LocalDate dueDate;
    private Boolean completed;

    public TaskItem() {
        this.completed = false;
    } //Empty Constructor

    public TaskItem(String inputDueDate, String inputTitle, String inputDescription) {
        setDueDate(inputDueDate);
        setTitle(inputTitle);
        setDescription(inputDescription);
        this.completed = false;
    }

    public void setCompleted() {
        this.completed = true;
    }

    public void setUncompleted() {
        this.completed = false;
    }

    public void setDueDate(String inputDueDate) {
        //A due date shall be in the format of YYYY-MM-DD
        try {
            this.dueDate = LocalDate.parse(inputDueDate);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Due dates should be in YYYY-MM-DD format");
        }
    }

    public void setTitle(String inputTitle) {
        //A title shall be 1 or more characters in length
        if (inputTitle.length() > 0) {
            this.title = inputTitle;
        } else {
            throw new IllegalArgumentException("Titles should be 1 or more characters in length");
        }
    }

    public void setDescription(String inputDescription) {
        //A description shall be 0 or more characters in length
        this.description = inputDescription;
    }

    public String getDueDate() {
        return this.dueDate.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        String TaskItemString = "";
        //+ represents completed, - represents uncompleted
        //separator is a zero-width-space. Essentialy an invisible space. Useful as a bookmark for where variables are.
        String separator = "\u200b";
        if (getCompleted()) {
            TaskItemString += (separator + "+ ");
        } else {
            TaskItemString += (separator + "- ");
        }
        TaskItemString += "[" + separator + getDueDate() + "]" + " " + separator + getTitle() + ": " + separator + getDescription() + separator;
        return TaskItemString;
    }
}