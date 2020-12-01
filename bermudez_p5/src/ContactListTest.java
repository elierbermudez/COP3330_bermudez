import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    //All of this is imported over from TaskListTest
    @Test
    public void addingContactItemsIncreasesSize() {
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);
        assertEquals(1, testList.size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);
        testList.editContactItemFirstName("", 0);
        testList.editContactItemLastName("", 0);
        testList.editContactItemPhone("", 0);
        try {
            testList.editContactItemEmail("", 0);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);

        try {
            testList.editContactItemEmail("Email2", 1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);
        testList.editContactItemFirstName("", 0);

        assertEquals("", testList.getContactItemFirstName(0));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);
        testList.editContactItemLastName("", 0);

        assertEquals("", testList.getContactItemLastName(0));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);
        testList.editContactItemPhone("", 0);

        assertEquals("", testList.getContactItemPhoneNumber(0));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);
        testList.editContactItemEmail("", 0);

        assertEquals("", testList.getContactItemEmail(0));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);
        testList.editContactItemFirstName("Elier2", 0);
        testList.editContactItemLastName("Bermudez2", 0);
        testList.editContactItemPhone("Phone2", 0);
        testList.editContactItemEmail("Email2", 0);

        assertEquals("Elier2", testList.getContactItemFirstName(0));
        assertEquals("Bermudez2", testList.getContactItemLastName(0));
        assertEquals("Phone2", testList.getContactItemPhoneNumber(0));
        assertEquals("Email2", testList.getContactItemEmail(0));
    }

    @Test
    public void newContactListIsEmpty() {
        ContactList testList = new ContactList();
        assertEquals(0, testList.size());
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);
        testList.removeContactItem(0);
        assertEquals(0, testList.size());
    }

    @Test
    public void removingContactItemFailsWithInvalidIndex(){
        ContactItem testItem = new ContactItem("Elier", "Bermudez", "Phone", "Email");
        ContactList testList = new ContactList();
        testList.addContactItem(testItem);

        try {
            testList.removeContactItem(1);
            assertEquals(0, 1);
        } catch (Exception ex) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void toStringContactItemListWorks(){
        ContactItem testItem1 = new ContactItem("Elier1", "Bermudez1", "Phone1", "Email1");
        ContactItem testItem2 = new ContactItem("Elier2", "Bermudez2", "Phone2", "Email2");
        ContactItem testItem3 = new ContactItem("Elier3", "Bermudez3", "Phone3", "Email3");
        ContactList testList = new ContactList();

        testList.addContactItem(testItem1);
        testList.addContactItem(testItem2);
        testList.addContactItem(testItem3);

        assertEquals("0) Name: \u200BElier1 \u200BBermudez1\n" + "Phone: \u200BPhone1\n" + "Email: \u200BEmail1\u200B\n" + "1) Name: \u200BElier2 \u200BBermudez2\n" + "Phone: \u200BPhone2\n" + "Email: \u200BEmail2\u200B\n" + "2) Name: \u200BElier3 \u200BBermudez3\n" + "Phone: \u200BPhone3\n" + "Email: \u200BEmail3\u200B\n", testList+"");
    }
}