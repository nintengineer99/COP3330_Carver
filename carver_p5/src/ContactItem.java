public class ContactItem {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;

    ContactItem(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    protected void checkContactValidity(String firstName, String lastName, String phoneNum, String email) {
        if (firstName.equals("") && lastName.equals("") && phoneNum.equals("") && email.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    protected void setFirstName(String newFirstName) {this.firstName = newFirstName;}

    protected void setLastName(String newLastName) {this.lastName = newLastName;}

    protected void setPhoneNumber(String newPhoneNum) {this.phoneNumber = newPhoneNum;}

    protected void setEmail(String newEmail) {this.email = newEmail;}
}
