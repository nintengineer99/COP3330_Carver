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

    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {

    }

    @Test
    public void editingSucceedsWithBlankFirstName() {

    }

    @Test
    public void editingSucceedsWithBlankLastName() {

    }

    @Test
    public void editingSucceedsWithBlankPhone() {

    }

    @Test
    public void editingSucceedsWithNonBlankValues() {

    }

    @Test
    public void newListIsEmpty() {

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