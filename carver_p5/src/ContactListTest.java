// library inclusions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    // adding a contact increases the list's contact count
    public void addingItemsIncreasesSize() {
        ContactList contacts = new ContactList();
        ContactItem contact = new ContactItem("Example", "Contact", "111-111-1111",
                "example@email.com");
        contacts.addContact(contact);
        assertEquals(1, contacts.contactCount);
    }

    @Test
    // checks that editing a contact fails when all fields are empty
    public void editingItemsFailsWithAllBlankValues() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ContactList contactList = new ContactList();
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contactList.addContact(contact);
                    contactList.editContact(0, "", "", "", "");
                }
        );
    }

    @Test
    // checks that editing a contact fails when user submits an out of bounds index
    public void editingItemsFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    ContactList contactList = new ContactList();
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contactList.addContact(contact);
                    contactList.editContact(1, "", "", "", "");
                }
        );
    }

    @Test
    // editing a contact w/ no first name succeeds
    public void editingSucceedsWithBlankFirstName() {
        assertDoesNotThrow( () -> {
            ContactList contactList = new ContactList();
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contactList.addContact(contact);
                    contactList.editContact(0, "", "New",
                            "222-222-2222", "example2@example.com");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    // editing a contact w/ no last name succeeds
    public void editingSucceedsWithBlankLastName() {
        assertDoesNotThrow( () -> {
                    ContactList contactList = new ContactList();
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contactList.addContact(contact);
                    contactList.editContact(0, "Someone", "",
                            "222-222-2222", "example2@example.com");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    // editing a contact w/ no phone number succeeds
    public void editingSucceedsWithBlankPhone() {
        assertDoesNotThrow( () -> {
                    ContactList contactList = new ContactList();
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contactList.addContact(contact);
                    contactList.editContact(0, "Someone", "New",
                            "", "example2@example.com");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    // editing a contact w/ no email succeeds
    public void editingSucceedsWithBlankEmail() {
        assertDoesNotThrow( () -> {
                    ContactList contactList = new ContactList();
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contactList.addContact(contact);
                    contactList.editContact(0, "Someone", "New",
                            "222-222-2222", "");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    // editing a contact w/ all fields filled succeeds
    public void editingSucceedsWithNonBlankValues() {
        assertDoesNotThrow( () -> {
                    ContactList contactList = new ContactList();
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contactList.addContact(contact);
                    contactList.editContact(0, "Someone", "New",
                            "222-222-2222", "example2@example.com");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    // checks that a new list has no contacts when created
    public void newListIsEmpty() {
        ContactList contactList = new ContactList();
        assertEquals(0, contactList.contactCount);
    }

    @Test
    // checks that removing a contact decreases the contact count
    public void removingItemsDecreasesSize() {
        ContactList contactList = new ContactList();
        ContactItem contactItem = new ContactItem("Example", "Contact",
                "111-111-1111", "example@email.com");
        contactList.addContact(contactItem);
        contactList.removeContact(0);
        assertEquals(0, contactList.contactCount);
    }

    @Test
    // checks that removing a contact fails when user passes an out of bounds index
    public void removingItemsFailsWithInvalidIndex() {
        Throwable exception = assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    ContactList contactList = new ContactList();
                    ContactItem contactItem = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contactList.addContact(contactItem);
                    contactList.removeContact(1);
                }
        );
    }

    @Test
    // checks that a saved list can be loaded without error
    public void savedContactListCanBeLoaded() {
        assertDoesNotThrow( () -> {
            ContactList contactList = new ContactList();
            contactList.loadContactList("example.txt");
        }
        );
    }
}