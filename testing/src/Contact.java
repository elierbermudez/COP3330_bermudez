public class Contact {
    public String name;
    public String email;
    public String phone_number;

    public Contact(){
        //Empty Constructor just in case
    }
    public Contact(String input_name, String input_email, String input_phone_number) {
        name = input_name;
        email = input_email;
        phone_number = input_phone_number;
    }

    //Name get and set
    public String getName(){
        return name;
    }
    public void setName(String input_name){
        name = input_name;
    }

    //Email get and set
    public String getEmail(){
        return email;
    }
    public void setEmail(String input_email){
        email = input_email;
    }

    //Phone number get and set
    public String getPhone_number(){
        return phone_number;
    }
    public void setPhone_number(String input_phone_number){
        phone_number = input_phone_number;
    }

    //This toString prints out the contact details
    public String toString(){
        String outputSentence=("Name: "+getName()+"\nEmail:  "+getEmail()+"\nPhone Number: "+getPhone_number()+".\n");
        return outputSentence;
    }
}