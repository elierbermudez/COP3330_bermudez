import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskItemTest {
    /*
    Implement these tests at a minimum:
    Note: In case your brain stops working, remember that setting means to change the variable for one that's already been created.
    settingTaskItemDueDateFailsWithInvalidDate()
    settingTaskItemDueDateSucceedsWithValidDate()

    settingTaskItemTitleFailsWithInvalidTitle()
    settingTaskItemTitleSucceedsWithValidTitle()
     */
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        boolean exceptionHappened = false;
        try {
            TaskItem testItem = new TaskItem("testTitle", "testDescription", "2000-02-30");
        }
        catch(IllegalArgumentException ex){
            exceptionHappened = true;
        }
        finally{
            assertEquals(true, exceptionHappened);
        }
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        boolean exceptionHappened = false;
        try {
            TaskItem testItem = new TaskItem("", "testDescription", "2000-03-04");
        }
        catch(IllegalArgumentException ex){
            exceptionHappened = true;
        }
        finally{
            assertEquals(true, exceptionHappened);
        }
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem testItem = new TaskItem("testTitle", "testDescription", "2000-03-04");
        assertEquals("2000-03-04", testItem.getDueDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem testItem = new TaskItem("testTitle", "testDescription", "2000-03-04");
        assertEquals("testTitle", testItem.getTitle());
    }
}