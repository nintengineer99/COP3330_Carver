import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
    static Scanner in = new Scanner(System.in);
    // begin contact app
    public static void main() {
        boolean shouldContinue = true;
        // operations should and will continue as long as user desires
        while (shouldContinue) {
            displayMainMenu();
            try {
                // user chooses whether to create a new list or load one
                int choice = in.nextInt();
                in.nextLine();
                switch(choice) {
                    // user creates a new list
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
                            // user submits a non-int choice
                            catch (InputMismatchException e) {
                                System.out.println("WARNING: You must enter your choice as an integer.");
                            }
                            // user enters an int less than 1 or greater than 6
                            catch (IndexOutOfBoundsException e) {
                                System.out.println("WARNING: You must enter a number from 1 to 6.");
                            }
                            finally {
                                in.nextLine();
                            }
                        }
                        break;
                    // user loads in an old list
                    case 2:
                        ContactList loadedContactList = new ContactList();
                        System.out.print("Enter the file name to load: ");
                        String fileName = in.nextLine();
                        loadedContactList.loadContactList(fileName);
                        System.out.println("Contact list has been loaded.");
                        boolean continueLoadedContactListOperations = true;
                        while (continueLoadedContactListOperations) {
                            displayListOperationMenu();
                            try {
                                int choice3 = in.nextInt();
                                in.nextLine();
                                continueLoadedContactListOperations = listOperationsMenu(choice3, loadedContactList);
                            }
                            // user submits a non-int choice
                            catch (InputMismatchException e) {
                                System.out.println("WARNING: You must enter your choice as an integer.");
                            }
                            // user enters an int less than 1 or greater than 6
                            catch (IndexOutOfBoundsException e) {
                                System.out.println("WARNING: You must enter a number from 1 to 6.");
                            }
                            finally {
                                in.nextLine();
                            }
                        }
                        break;
                    // user quits back to app menu
                    case 3:
                        shouldContinue = false;
                        break;
                    default:
                        throw new IndexOutOfBoundsException();
                }
            }
            // user submits a choice that is less than 1 or greater than 3
            catch (IndexOutOfBoundsException e) {
                System.out.println("WARNING: You must enter a number from 1 to 3.");
            }
            // user does not submit an integer choice
            catch (InputMismatchException e) {
                System.out.println("WARNING: You must enter your choice as an integer.");
            }
            // user submits a file name that does not exist
            catch (IOException e) {
                System.out.println("WARNING: File could not be found. No file loaded.");
            }
            finally {
                in.nextLine();
            }
        }
    }

    // menu where user chooses what to do with their list
    private static boolean listOperationsMenu(int choice, ContactList contactList) {
        switch(choice) {
            // print out all contacts in the list
            case 1:
                System.out.println("Current Contacts");
                System.out.println("----------------");
                printContacts(contactList);
                break;
            // add a new contact to the list
            case 2:
                addContactToList(contactList);
                break;
            // edit a contact in the list
            case 3:
                editContactInList(contactList);
                break;
            // remove a contact from the list
            case 4:
                removeContactFromList(contactList);
                break;
            // save the list to a file
            case 5:
                saveContactListToFile(contactList);
                break;
            // quit back to main menu of contact app
            case 6:
                return false;
            default:
                throw new IndexOutOfBoundsException();
        }
        return true;
    }

    // method to save contact list to a file
    private static void saveContactListToFile(ContactList contactList) {
        try {
            // if no contacts exist stop from saving
            if (contactList.contactCount == 0) {
                throw new NoSuchFieldException();
            }
            System.out.print("Enter the file name to save as: ");
            String fileName = in.nextLine();
            contactList.saveContactList(fileName);
            System.out.println("Contact list has been saved.");
        }
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: You have no contacts to save.");
        }
        catch (FileNotFoundException e) {
            System.out.println("WARNING: No such file exists. List not saved.");
        }
    }

    // method to remove contact from current list
    private static void removeContactFromList(ContactList contactList) {
        try {
            // if no contacts exist stop from removing
            if (contactList.contactCount == 0) {
                throw new NoSuchFieldException();
            }
            // print out contacts
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
        // user submits a non-int index
        catch(InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the contact you wish to remove as an integer (0-based).");
        }
        // user submits an out of bounds index
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot remove that contact because you called for an invalid index.");
        }
    }

    // method to edit a contact currently in the list
    private static void editContactInList(ContactList contactList) {
        try {
            // if no contacts exist stop from editing
            if (contactList.contactCount == 0) {
                throw new NoSuchFieldException();
            }
            // print out current contact list
            System.out.println("Current Contacts");
            System.out.println("----------------");
            printContacts(contactList);
            System.out.print("What contact will you edit? ");
            int index = in.nextInt();
            in.nextLine();
            if (index < 0 || (index + 1) > contactList.contactCount) {
                throw new IndexOutOfBoundsException();
            }
            // user submits new info for the contact to be updated
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
        // user submits a non-int index
        catch (InputMismatchException e) {
            System.out.println("WARNING: You must enter the index of the contact you wish to edit as an integer (0-based).");
        }
        catch (NoSuchFieldException e) {
            System.out.println("WARNING: There are currently no contacts to edit.");
        }
        // user submits an out of bounds index
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: You cannot access that contact because you called for an invalid index.");
        }
        // user must fill at least one field in the contact
        catch (IllegalArgumentException e) {
            System.out.println("WARNING: At least one field must be filled. Contact not created.");
        }
    }

    // method to print all contacts currently in the list
    private static void printContacts(ContactList contactList) {
        for (int i = 0; i < contactList.contactCount; i++) {
            ContactItem currentContact = contactList.getContact(i);
            System.out.printf("%d) Name: %s %s%nPhone: %s%nEmail: %s%n%n", i, currentContact.firstName,
                    currentContact.lastName, currentContact.phoneNumber, currentContact.email);
        }
    }

    // method to add a new contact to the list
    private static void addContactToList(ContactList contactList) {
        // user enters contact's information
        System.out.print("First name: ");
        String firstName = in.nextLine();
        System.out.print("Last name: ");
        String lastName = in.nextLine();
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        String phoneNum = in.nextLine();
        System.out.print("Email address (x@y.z): ");
        String email = in.nextLine();
        // add contact to list
        try {
            ContactItem contact = new ContactItem(firstName, lastName, phoneNum, email);
            contact.checkContactValidity(firstName, lastName, phoneNum, email);
            contactList.addContact(contact);
        }
        // user must fill at least one field in the contact
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
