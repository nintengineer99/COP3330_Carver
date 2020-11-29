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

    protected void checkContactValidity() {
        if (firstName.equals("") && lastName.equals("") && phoneNumber.equals("") && email.equals("")) {
            throw new IllegalArgumentException();
        }
    }
}
