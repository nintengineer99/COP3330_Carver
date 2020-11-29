// library inclusions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactList contacts = new ContactList();
        ContactItem contact = new ContactItem("Example", "Contact", "111-111-1111",
                "example@email.com");
        contacts.addContact(contact);
        assertEquals(1, contacts.contactCount);
    }

    @Test
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
    public void newListIsEmpty() {
        ContactList contactList = new ContactList();
        assertEquals(0, contactList.contactCount);
    }

    @Test
    public void removingItemsDecreasesSize() {

    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {

    }

    @Test
    public void savedContactListCanBeLoaded() {

    }
}