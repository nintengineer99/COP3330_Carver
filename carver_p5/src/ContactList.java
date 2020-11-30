// library inclusions
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ContactList {
    // counter to keep track of number of contacts
    int contactCount = 0;
    ArrayList<ContactItem> contacts = new ArrayList<>();

    // adds contact to arraylist
    protected void addContact(ContactItem contact) {
        contacts.add(contact);
        contactCount++;
    }

    // get the contact specified by the user
    protected ContactItem getContact(int index) {return contacts.get(index);}

    // edit contact in the arraylist
    protected void editContact(int index, String newFirstName, String newLastName, String newPhoneNum, String newEmail) {
        ContactItem editedContact = getContact(index);
        editedContact.checkContactValidity(newFirstName, newLastName, newPhoneNum, newEmail);
        editedContact.setFirstName(newFirstName);
        editedContact.setLastName(newLastName);
        editedContact.setPhoneNumber(newPhoneNum);
        editedContact.setEmail(newEmail);
    }

    // removes contact from arraylist
    protected void removeContact(int index) {
        contacts.remove(index);
        contactCount--;
    }

    // saves list to file
    protected void saveContactList(String fileName) throws FileNotFoundException {
        Formatter output = new Formatter(fileName);
        for (int i = 0; i < contactCount; i++) {
            ContactItem contactItem = getContact(i);
            output.format(contactItem.toString());
        }
        output.close();
    }

    // loads info from file into list
    protected void loadContactList(String fileName) throws IOException {
        try (Scanner file = new Scanner(Paths.get(fileName))) {
            while (file.hasNext()) {
                String loadedFirstName = file.nextLine();
                String loadedLastName = file.nextLine();
                String loadedPhoneNum = file.nextLine();
                String loadedEmail = file.nextLine();
                ContactItem loadedContact = new ContactItem(loadedFirstName, loadedLastName,
                        loadedPhoneNum, loadedEmail);
                loadedContact.checkContactValidity(loadedFirstName, loadedLastName,
                        loadedPhoneNum, loadedEmail);
                addContact(loadedContact);
            }
        }
    }
}