public class ContactItem {
    //All of this is imported over from TaskItem for now
    /*
    A contact item shall contain a first name
A contact item shall contain a last name
A contact item shall contain a phone number
A contact item shall contain an email address
A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]
     */
    // Use Ctrl + Shift + F10 to run your code. Remember to use Fn on your laptop to make F10 work properly.
    // Use Ctrl + Alt + L to format your code.
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public ContactItem() {
    } //Empty Constructor

    public ContactItem(String inputFirstName, String inputLastName, String inputPhoneNumber, String inputEmail) {
        if((inputFirstName+inputLastName+inputPhoneNumber+inputEmail).length()!=0) {
            setFirstName(inputFirstName);
            setLastName(inputLastName);
            setPhoneNumber(inputPhoneNumber);
            setEmail(inputEmail);
        }
        else{
            throw new IllegalArgumentException("A contact must have at least a first name, last name, phone number, or email.");
        }
    }

    public void setFirstName(String inputFirstName) {
        if((inputFirstName+this.lastName+this.phoneNumber+this.email).length()!=0){
            this.firstName = inputFirstName;
        }
        else{
            throw new IllegalArgumentException("Changing this would make all fields blank. Contacts " +
                    "must have at least a first name, last name, phone number, or email.");
        }
    }

    public void setLastName(String inputLastName) {
        if((this.firstName+inputLastName+this.phoneNumber+this.email).length()!=0) {
            this.lastName = inputLastName;
        }
        else{
            throw new IllegalArgumentException("Changing this would make all fields blank. Contacts " +
                    "must have at least a first name, last name, phone number, or email.");
        }
    }

    public void setPhoneNumber(String inputPhoneNumber) {
        if((this.firstName+this.lastName+inputPhoneNumber+this.email).length()!=0){
        this.phoneNumber = inputPhoneNumber;
        }
        else{
            throw new IllegalArgumentException("Changing this would make all fields blank. Contacts " +
                    "must have at least a first name, last name, phone number, or email.");
        }
    }

    public void setEmail(String inputEmail) {
        if((this.firstName+this.lastName+this.phoneNumber+inputEmail).length()!=0) {
            this.email = inputEmail;
        }
        else{
            throw new IllegalArgumentException("Changing this would make all fields blank. Contacts " +
                    "must have at least a first name, last name, phone number, or email.");
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        /* Format for how output should be is roughly this:
        Name: John Doe
        Phone: 555-123-1234
        Email: unknown@cia.gov
         */
        String ContactItemString = "";
        //separator is a zero-width-space. Essentially an invisible space. Useful as a bookmark for where variables are.
        String separator = "\u200b";
        ContactItemString += "Name: " + separator + getFirstName() + " " + separator + getLastName() +
                "\nPhone: " + separator + getPhoneNumber() + "\nEmail: " + separator + getEmail() +separator;
        return ContactItemString;
    }
}
