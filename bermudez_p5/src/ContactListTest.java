import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    /* Implement these tests at a minimum:
addingItemsIncreasesSize()
editingItemsFailsWithAllBlankValues()
editingItemsFailsWithInvalidIndex()
editingSucceedsWithBlankFirstName()
editingSucceedsWithBlankLastName()
editingSucceedsWithBlankPhone()
editingSucceedsWithNonBlankValues()
newListIsEmpty()
removingItemsDecreasesSize()
removingItemsFailsWithInvalidIndex()
savedContactListCanBeLoaded()
     */
    //All of this is imported over from TaskListTest
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        assertEquals(1, testList.size());
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        testList.completeTaskItem(0);
        assertEquals(true, testList.getTaskItemCompletion(0));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        try {
            testList.completeTaskItem(1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        testList.editTaskItemDueDate("2000-03-05", 0);
        testList.editTaskItemTitle("testTitle2", 0);
        testList.editTaskItemDescription("testDescription2", 0);
        try {
            assertEquals("2000-03-05", testItem.getDueDate());
            assertEquals("testTitle2", testItem.getTitle());
            assertEquals("testDescription2", testItem.getDescription());
        } catch (Exception ex) {
            assertEquals(0, 1);
        }
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        testList.editTaskItemDescription("testDescription2", 0);
        assertEquals("testDescription2", testItem.getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        try {
            testList.editTaskItemDescription("testDescription2", 1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        testList.editTaskItemDueDate("2000-03-05", 0);
        assertEquals("2000-03-05", testItem.getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        try {
            testList.editTaskItemDueDate("2000-03-05", 1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        testList.editTaskItemTitle("testTitle2", 0);
        assertEquals("testTitle2", testItem.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        try {
            testList.editTaskItemTitle("testTitle2", 1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        try {
            testList.getTaskItemDescription(1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        assertEquals("testDescription", testList.getTaskItemDescription(0));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        try {
            testList.getTaskItemDueDate(1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        assertEquals("2000-03-04", testList.getTaskItemDueDate(0));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        try {
            testList.getTaskItemTitle(1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        assertEquals("testTitle", testList.getTaskItemTitle(0));
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        assertEquals(0, testList.size());
    }

    /*
    removingTaskItemsDecreasesSize()
    removingTaskItemsFailsWithInvalidIndex()
     */
    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        testList.removeTaskItem(0);
        assertEquals(0, testList.size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        try {
            testList.removeTaskItem(1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        testList.completeTaskItem(0);
        testList.uncompleteTaskItem(0);
        assertFalse(testList.getTaskItemCompletion(0));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem);
        testList.completeTaskItem(0);
        try {
            testList.uncompleteTaskItem(1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void toStringTaskItemListWorks() {
        TaskItem testItem1 = new TaskItem("2000-03-01", "testTitle1", "testDescription1");
        TaskItem testItem2 = new TaskItem("2000-03-02", "testTitle2", "testDescription2");
        TaskItem testItem3 = new TaskItem("2000-03-03", "testTitle3", "testDescription3");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem1);
        testList.addTaskItem(testItem2);
        testList.addTaskItem(testItem3);
        testList.completeTaskItem(1);
        assertEquals("0) \u200B- [\u200B2000-03-01] \u200BtestTitle1: \u200BtestDescription1\u200B\n" +
                "1) \u200B+ [\u200B2000-03-02] \u200BtestTitle2: \u200BtestDescription2\u200B\n" +
                "2) \u200B- [\u200B2000-03-03] \u200BtestTitle3: \u200BtestDescription3\u200B\n", testList + "");
    }

    @Test
    public void getCompletedTaskItemsAsStringWorks() {
        TaskItem testItem1 = new TaskItem("2000-03-01", "testTitle1", "testDescription1");
        TaskItem testItem2 = new TaskItem("2000-03-02", "testTitle2", "testDescription2");
        TaskItem testItem3 = new TaskItem("2000-03-03", "testTitle3", "testDescription3");
        TaskItem testItem4 = new TaskItem("2000-03-04", "testTitle4", "testDescription4");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem1);
        testList.addTaskItem(testItem2);
        testList.addTaskItem(testItem3);
        testList.addTaskItem(testItem4);
        testList.completeTaskItem(1);
        testList.completeTaskItem(3);
        assertEquals("1) \u200B+ [\u200B2000-03-02] \u200BtestTitle2: \u200BtestDescription2\u200B\n" +
                "3) \u200B+ [\u200B2000-03-04] \u200BtestTitle4: \u200BtestDescription4\u200B\n", testList.getCompletedTaskItemsAsString());
    }

    @Test
    public void getUncompletedTaskItemsAsStringWorks() {
        TaskItem testItem1 = new TaskItem("2000-03-01", "testTitle1", "testDescription1");
        TaskItem testItem2 = new TaskItem("2000-03-02", "testTitle2", "testDescription2");
        TaskItem testItem3 = new TaskItem("2000-03-03", "testTitle3", "testDescription3");
        TaskItem testItem4 = new TaskItem("2000-03-04", "testTitle4", "testDescription4");
        TaskList testList = new TaskList();
        testList.addTaskItem(testItem1);
        testList.addTaskItem(testItem2);
        testList.addTaskItem(testItem3);
        testList.addTaskItem(testItem4);
        testList.completeTaskItem(1);
        testList.completeTaskItem(3);
        assertEquals("0) \u200B- [\u200B2000-03-01] \u200BtestTitle1: \u200BtestDescription1\u200B\n" +
                "2) \u200B- [\u200B2000-03-03] \u200BtestTitle3: \u200BtestDescription3\u200B\n", testList.getUncompletedTaskItemsAsString());
    }
}