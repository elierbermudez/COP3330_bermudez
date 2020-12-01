import java.util.ArrayList;

public class ContactList {
    // Use Ctrl + Shift + F10 to format your code. Remember to use Fn on your laptop to make F10 work properly.

    //A contact list shall contain 1 or more contact items
    private ArrayList<ContactItem> internalContactList = new ArrayList<ContactItem>();

    public ContactList() {
        ;
    } //Empty Constructor

    public void addContactItem(ContactItem externalContactItem) {
        this.internalContactList.add(externalContactItem);
    }

    public void editingTaskItemChangesValues(String inputFirstName, String inputLastName, String inputPhone, String inputEmail, int index) {
        editContactItemFirstName(inputFirstName, index);
        editContactItemLastName(inputLastName, index);
        editContactItemPhone(inputPhone, index);
        editContactItemEmail(inputEmail, index);
    }

    public void editContactItemFirstName(String inputFirstName, int index) {
        this.internalContactList.get(index).setFirstName(inputFirstName);
    }

    public void editContactItemLastName(String inputLastName, int index) {
        this.internalContactList.get(index).setLastName(inputLastName);
    }

    public void editContactItemPhone(String inputPhone, int index) {
        this.internalContactList.get(index).setPhoneNumber(inputPhone);
    }

    public void editContactItemEmail(String inputEmail, int index) {
        this.internalContactList.get(index).setEmail(inputEmail);
    }

    public String getContactItemFirstName(int index){
        return this.internalContactList.get(index).getFirstName();
    }

    public String getContactItemLastName(int index){
        return this.internalContactList.get(index).getLastName();
    }

    public String getContactItemPhoneNumber(int index){
        return this.internalContactList.get(index).getPhoneNumber();
    }

    public String getContactItemEmail(int index){
        return this.internalContactList.get(index).getEmail();
    }

    public ContactItem getContactItem(int index){
        return this.internalContactList.get(index);
    }

    public void removeContactItem(int index){
        this.internalContactList.remove(index);
    }

    public int size() {
        return this.internalContactList.size();
    }

    public String getContactItemAsString(int index){
        return(getContactItem(index)+"");
    }

    @Override
    public String toString() {
        StringBuilder ContactListString = new StringBuilder();
        int i = 0;
        for (i = 0; i < this.size(); i++) {
            ContactListString.append(i + ") ").append(this.getContactItem(i)).append("\n");
        }
        return ContactListString.toString();
    }
}
