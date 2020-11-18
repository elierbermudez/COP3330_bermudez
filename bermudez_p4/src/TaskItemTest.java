import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        boolean exceptionHappened = false;
        try {
            TaskItem testItem = new TaskItem("2000-02-30", "testTitle", "testDescription");
        } catch (IllegalArgumentException ex) {
            exceptionHappened = true;
        } finally {
            assertEquals(true, exceptionHappened);
        }
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        boolean exceptionHappened = false;
        try {
            TaskItem testItem = new TaskItem("2000-03-04", "", "testDescription");
        } catch (IllegalArgumentException ex) {
            exceptionHappened = true;
        } finally {
            assertEquals(true, exceptionHappened);
        }
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        assertEquals("2000-03-04", testItem.getDueDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        assertEquals("testTitle", testItem.getTitle());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        boolean exceptionHappened = false;
        try {
            TaskItem testItem = new TaskItem("2000-02-28", "testTitle", "testDescription");
            testItem.setDueDate("2000-02-30");
        } catch (IllegalArgumentException ex) {
            exceptionHappened = true;
        } finally {
            assertEquals(true, exceptionHappened);
        }
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        boolean exceptionHappened = false;
        try {
            TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
            testItem.setTitle("");
        } catch (IllegalArgumentException ex) {
            exceptionHappened = true;
        } finally {
            assertEquals(true, exceptionHappened);
        }
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        testItem.setDueDate("2000-04-10");
        assertEquals("2000-04-10", testItem.getDueDate());
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        testItem.setTitle("testTitle2");
        assertEquals("testTitle2", testItem.getTitle());
    }

    @Test
    public void settingTaskItemDescriptionSucceeds() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        testItem.setDescription("testDescription2");
        assertEquals("testDescription2", testItem.getDescription());
    }

    @Test
    public void newTaskItemCompletedIsFalse() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        assertFalse(testItem.getCompleted());
    }

    @Test
    public void setTaskItemCompletedWorks() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        testItem.setCompleted();
        assertFalse(!testItem.getCompleted());
    }

    @Test
    public void setTaskItemUncompletedWorks() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        testItem.setUncompleted();
        assertFalse(testItem.getCompleted());
    }

    @Test
    public void toStringTaskItemWorks(){
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        System.out.println(testItem+"");
    }

    @Test
    public void toStringTaskItemWorksCase2(){
        TaskItem testItem = new TaskItem("2001-01-02", "testTitle2", "testDescription2");
        testItem.setCompleted();
        assertEquals("+ [\u200b2001-01-02] \u200btestTitle2 \u200btestDescription2", testItem+"");
    }
}