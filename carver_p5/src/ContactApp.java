import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContactApp {
    static Scanner in = new Scanner(System.in);
    public static void main() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            displayMainMenu();
            try {
                int choice = in.nextInt();
                switch(choice) {
                    case 1:
                        ContactList contactList = new ContactList();
                        boolean continueListOps = true;
                        System.out.println("New contact list has been created.");
                        while (continueListOps) {
                            displayListOperationMenu();
                            try {
                                int choice2 = in.nextInt();
                                in.nextLine();
                                continueListOps = listOperationsMenu(choice2, contactList);
                            }
                            catch (InputMismatchException e) {
                                System.out.println("WARNING: You must enter your choice as an integer.");
                            }
                            catch (IndexOutOfBoundsException e) {
                                System.out.println("WARNING: You must enter a number from 1 to 6.");
                            }
                            finally {
                                in.nextLine();
                            }
                        }
                        break;
                    case 2:

                        break;
                    case 3:
                        shouldContinue = false;
                        break;
                    default:
                        throw new IndexOutOfBoundsException();
                }
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("WARNING: You must enter a number from 1 to 3.");
            }
            catch (InputMismatchException e) {
                System.out.println("WARNING: You must enter your choice as an integer.");
            }
            finally {
                in.nextLine();
            }
        }
    }

    private static boolean listOperationsMenu(int choice, ContactList contactList) {
        switch(choice) {
            case 1:
                System.out.println("Current Contacts");
                System.out.println("----------------");
                printContacts(contactList);
                break;
            case 2:
                addContactToList(contactList);
                break;
            case 3:
                editContactInList(contactList);
                break;
            case 4:
                removeContactFromList(contactList);
                break;
            case 5:

                break;
            case 6:
                return false;
            default:
                throw new IndexOutOfBoundsException();
        }
        return true;
    }

    private static void removeContactFromList(ContactList contactList) {
        try {
            if (contactList.contactCount == 0) {
                throw new NoSuchFieldException();
            }
            System.out.println("Current Contacts");
            System.out.println("----------------");
            printContacts(contactList);
            System.out.print("What contact will you remove? ");
            int index = in.nextInt();
            if (index < 0 || (index + 1) > contactList.contactCount) {
                throw new IndexOutOfBoundsException();
            }
            contactList.removeContact(index);
        }
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: You have no contacts to remove.");
        }
        catch(InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the contact you wish to remove as an integer (0-based).");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot remove that contact because you called for an invalid index.");
        }
    }

    private static void editContactInList(ContactList contactList) {
        try {
            if (contactList.contactCount == 0) {
                throw new NoSuchFieldException();
            }
            System.out.println("Current Contacts");
            System.out.println("----------------");
            printContacts(contactList);
            System.out.print("What contact will you edit? ");
            int index = in.nextInt();
            in.nextLine();
            if (index < 0 || (index + 1) > contactList.contactCount) {
                throw new IndexOutOfBoundsException();
            }
            System.out.print("Enter a new first name for contact " + index + ": ");
            String newFirstName = in.nextLine();
            System.out.print("Enter a new last name for contact " + index + ": ");
            String newLastName = in.nextLine();
            System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + index + ": ");
            String newPhoneNum = in.nextLine();
            System.out.print("Enter a new email address (x@y.z) for contact " + index + ": ");
            String newEmail = in.nextLine();
            contactList.editContact(index, newFirstName, newLastName, newPhoneNum, newEmail);
        }
        catch (InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the contact you wish to edit as an integer (0-based).");
        }
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: There are currently no contacts to edit.");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot access that contact because you called for an invalid index.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("WARNING: At least one field must be filled. Contact not created.");
        }
    }

    private static void printContacts(ContactList contactList) {
        for (int i = 0; i < contactList.contactCount; i++) {
            ContactItem currentContact = contactList.getContact(i);
            System.out.printf("%d) Name: %s %s%nPhone: %s%nEmail: %s%n%n", i, currentContact.firstName,
                    currentContact.lastName, currentContact.phoneNumber, currentContact.email);
        }
    }

    private static void addContactToList(ContactList contactList) {
        System.out.print("First name: ");
        String firstName = in.nextLine();
        System.out.print("Last name: ");
        String lastName = in.nextLine();
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        String phoneNum = in.nextLine();
        System.out.print("Email address (x@y.z): ");
        String email = in.nextLine();
        try {
            ContactItem contact = new ContactItem(firstName, lastName, phoneNum, email);
            contact.checkContactValidity(firstName, lastName, phoneNum, email);
            contactList.addContact(contact);
        }
        catch (IllegalArgumentException e) {
            System.out.println("WARNING: At least one field must be filled. Contact not edited.");
        }
    }

    // display main menu options for user
    private static void displayMainMenu() {
        System.out.printf("Main Menu%n" +
                "---------%n%n" +
                "1) Create a new list%n" +
                "2) Load an existing list%n" +
                "3) Quit%n%n" +
                "> ");
    }

    // display list ops choices for user
    private static void displayListOperationMenu() {
        System.out.printf("List Operation Menu%n" +
                "---------%n%n" +
                "1) View the list%n" +
                "2) Add an item%n" +
                "3) Edit an item%n" +
                "4) Remove an item%n" +
                "5) Save the current list%n" +
                "6) Quit to the main menu%n%n" +
                "> ");
    }
}
