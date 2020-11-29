import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class ContactList {
    int contactCount = 0;
    ArrayList<ContactItem> contacts = new ArrayList<>();

    protected void addContact(ContactItem contact) {
        contacts.add(contact);
        contactCount++;
    }

    protected ContactItem getContact(int index) {return contacts.get(index);}

    protected int getContactIndex(ContactItem contact) {return contacts.indexOf(contact);}

    protected void editContact(int index, String newFirstName, String newLastName, String newPhoneNum, String newEmail) {
        ContactItem editedContact = getContact(index);
        editedContact.checkContactValidity(newFirstName, newLastName, newPhoneNum, newEmail);
        editedContact.setFirstName(newFirstName);
        editedContact.setLastName(newLastName);
        editedContact.setPhoneNumber(newPhoneNum);
        editedContact.setEmail(newEmail);
    }

    protected void removeContact(int index) {
        contacts.remove(index);
        contactCount--;
    }

    protected void saveContactList(String fileName) throws FileNotFoundException {
        Formatter output = new Formatter(fileName);
        for (int i = 0; i < contactCount; i++) {
            ContactItem contactItem = getContact(i);
            output.format(contactItem.toString());
        }
        output.close();
    }
}
