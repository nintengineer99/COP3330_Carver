public class ContactItem {
    // contact info
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;

    // contact item constructor
    ContactItem(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // checks that at least one field of the contact is filled in
    protected void checkContactValidity(String firstName, String lastName, String phoneNum, String email) {
        if (firstName.equals("") && lastName.equals("") && phoneNum.equals("") && email.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    // set methods
    protected void setFirstName(String newFirstName) {this.firstName = newFirstName;}

    protected void setLastName(String newLastName) {this.lastName = newLastName;}

    protected void setPhoneNumber(String newPhoneNum) {this.phoneNumber = newPhoneNum;}

    protected void setEmail(String newEmail) {this.email = newEmail;}

    // tostring method that is used to format file
    @Override
    public String toString() {
        return(firstName + "%n" + lastName + "%n" + phoneNumber + "%n" + email);
    }
}
