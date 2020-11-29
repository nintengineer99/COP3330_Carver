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
                            catch (Exception e) {

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
                }
            }
            catch (Exception e){

            }
            finally {

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

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:
                return false;
        }
        return true;
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
            contact.checkContactValidity();
            contactList.addContact(contact);
        }
        catch (IllegalArgumentException e) {
            System.out.println("WARNING: At least one field must be filled. Contact not created.");
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
