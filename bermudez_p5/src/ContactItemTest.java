import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactItemTest {
    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        assertEquals("Elier", testItem.getFirstName());
        assertEquals("Bermudez", testItem.getLastName());
        assertEquals("Phone", testItem.getPhoneNumber());
        assertEquals("Email", testItem.getEmail());
    }

    @Test
    public void creationFailsWithAllBlankValues() {
        boolean exceptionHappened = false;
        try {
            ContactItem testItem = new ContactItem("", "", "", "");
        } catch (IllegalArgumentException ex) {
            exceptionHappened = true;
        } finally {
            assertTrue(exceptionHappened);
        }
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem testItem = new ContactItem("", "Bermudez", "Phone", "Email");
        assertEquals("", testItem.getFirstName());
        assertEquals("Bermudez", testItem.getLastName());
        assertEquals("Phone", testItem.getPhoneNumber());
        assertEquals("Email", testItem.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem testItem = new ContactItem("Elier", "", "Phone", "Email");
        assertEquals("Elier", testItem.getFirstName());
        assertEquals("", testItem.getLastName());
        assertEquals("Phone", testItem.getPhoneNumber());
        assertEquals("Email", testItem.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "", "Email");
        assertEquals("Elier", testItem.getFirstName());
        assertEquals("Bermudez", testItem.getLastName());
        assertEquals("", testItem.getPhoneNumber());
        assertEquals("Email", testItem.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "");
        assertEquals("Elier", testItem.getFirstName());
        assertEquals("Bermudez", testItem.getLastName());
        assertEquals("Phone", testItem.getPhoneNumber());
        assertEquals("", testItem.getEmail());
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        testItem.setFirstName("Elier2");
        testItem.setLastName("Bermudez2");
        testItem.setPhoneNumber("Phone2");
        testItem.setEmail("Email2");
        assertEquals("Elier2", testItem.getFirstName());
        assertEquals("Bermudez2", testItem.getLastName());
        assertEquals("Phone2", testItem.getPhoneNumber());
        assertEquals("Email2", testItem.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        testItem.setFirstName("");
        assertEquals("", testItem.getFirstName());
        assertEquals("Bermudez", testItem.getLastName());
        assertEquals("Phone", testItem.getPhoneNumber());
        assertEquals("Email", testItem.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        testItem.setLastName("");
        assertEquals("Elier", testItem.getFirstName());
        assertEquals("", testItem.getLastName());
        assertEquals("Phone", testItem.getPhoneNumber());
        assertEquals("Email", testItem.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        testItem.setPhoneNumber("");
        assertEquals("Elier", testItem.getFirstName());
        assertEquals("Bermudez", testItem.getLastName());
        assertEquals("", testItem.getPhoneNumber());
        assertEquals("Email", testItem.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        testItem.setEmail("");
        assertEquals("Elier", testItem.getFirstName());
        assertEquals("Bermudez", testItem.getLastName());
        assertEquals("Phone", testItem.getPhoneNumber());
        assertEquals("", testItem.getEmail());
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        testItem.setFirstName("");
        testItem.setLastName("");
        testItem.setPhoneNumber("");

        boolean exceptionHappened = false;
        try {
            testItem.setEmail("");
        } catch (IllegalArgumentException ex) {
            exceptionHappened = true;
        } finally {
            assertTrue(exceptionHappened);
        }
    }

    @Test
    public void toStringContactItemWorks() {
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        assertEquals("Name: \u200BElier \u200BBermudez\n" + "Phone: \u200BPhone\n" + "Email: \u200BEmail\u200B", testItem + "");
    }

    /*
    @Test
    public void toStringTaskItemWorks() {
        TaskItem testItem = new TaskItem("2000-03-04", "testTitle", "testDescription");
        assertEquals("\u200B- [\u200B2000-03-04] \u200BtestTitle: \u200BtestDescription\u200B", testItem + "");
    }

    @Test
    public void toStringTaskItemWorksCase2() {
        TaskItem testItem = new TaskItem("2001-01-02", "testTitle2", "testDescription2");
        testItem.setCompleted();
        assertEquals("\u200B+ [\u200B2001-01-02] \u200BtestTitle2: \u200BtestDescription2\u200B", testItem + "");
    }
    */
}