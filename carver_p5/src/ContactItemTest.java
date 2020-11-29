// library inclusions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        Throwable exception = assertThrows(
            IllegalArgumentException.class, () -> {
                ContactItem contact = new ContactItem("", "", "", "");
                contact.checkContactValidity();
            }
        );
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "");
                    contact.checkContactValidity();
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.checkContactValidity();
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "",
                            "111-111-1111", "example@email.com");
                    contact.checkContactValidity();
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "", "example@email.com");
                    contact.checkContactValidity();
                }
        );
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.checkContactValidity();
                }
        );
    }

    @Test
    public void editingFailsWithAllBlankValues() {

    }

    @Test
    public void editingSucceedsWithBlankEmail() {

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
    public void testToString() {

    }
}
