// library inclusions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        Throwable exception = assertThrows(
            IllegalArgumentException.class, () -> {
                ContactItem contact = new ContactItem("", "", "", "");
                contact.checkContactValidity("", "", "", "");
            }
        );
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "");
                    contact.checkContactValidity("Example", "Contact",
                            "111-111-1111", "");
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.checkContactValidity("", "Contact",
                            "111-111-1111", "example@email.com");
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "",
                            "111-111-1111", "example@email.com");
                    contact.checkContactValidity("Example", "",
                            "111-111-1111", "example@email.com");
                }
        );
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "", "example@email.com");
                    contact.checkContactValidity("Example", "Contact",
                            "", "example@email.com");
                }
        );
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.checkContactValidity("Example", "Contact",
                            "111-111-1111", "example@email.com");
                }
        );
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.setFirstName("");
                    contact.setLastName("");
                    contact.setPhoneNumber("");
                    contact.setEmail("");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.setFirstName("Someone");
                    contact.setLastName("New");
                    contact.setPhoneNumber("222-222-2222");
                    contact.setEmail("");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.setFirstName("");
                    contact.setLastName("New");
                    contact.setPhoneNumber("222-222-2222");
                    contact.setEmail("example2@example.com");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.setFirstName("Someone");
                    contact.setLastName("");
                    contact.setPhoneNumber("222-222-2222");
                    contact.setEmail("example2@email.com");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.setFirstName("Someone");
                    contact.setLastName("New");
                    contact.setPhoneNumber("");
                    contact.setEmail("example2@email.com");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        assertDoesNotThrow( () -> {
                    ContactItem contact = new ContactItem("Example", "Contact",
                            "111-111-1111", "example@email.com");
                    contact.setFirstName("Someone");
                    contact.setLastName("New");
                    contact.setPhoneNumber("222-222-2222");
                    contact.setEmail("example2@email.com");
                    contact.checkContactValidity(contact.firstName, contact.lastName, contact.phoneNumber,
                            contact.email);
                }
        );
    }

    @Test
    public void testToString() {

    }
}
