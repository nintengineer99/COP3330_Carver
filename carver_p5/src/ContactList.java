import java.util.ArrayList;

public class ContactList {
    int contactCount = 0;
    ArrayList<ContactItem> contacts = new ArrayList<>();

    protected void addContact(ContactItem contact) {
        contacts.add(contact);
        contactCount++;
    }

    protected ContactItem getContact(int index) {return contacts.get(index);}

    protected int getContactIndex(ContactItem contact) {return contacts.indexOf(contact);}
}
