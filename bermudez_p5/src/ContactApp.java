import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;

public class ContactApp {
    private static Scanner scan;

    public static void mainContact() {
        scan = new Scanner(System.in);
        openContactMainMenu();
    }

    private static void openContactMainMenu() {
        int response;
        while (true) {
            printContactMainMenu();
            response = scan.nextInt();
            scan.nextLine();

            switch (response) {
                case 1 -> {
                    System.out.println("New contact list has been created\n");
                    ContactList appContactList = new ContactList();
                    openContactListMenu(appContactList);
                }
                case 2 -> openContactLoadMenu();
                case 3 -> App.openApplicationMainMenu();
                default -> System.out.println("I'm not sure I understood that. Please enter the number 1, 2, or 3\n");
            }
        }
    }

    private static void openContactLoadMenu() {
        System.out.println("Enter the filename to load:");
        String filename = scan.nextLine();
        ContactList appContactList = new ContactList();

        try (Scanner fileInput = new Scanner(Paths.get(filename))) {
            loadContactListFromFile(appContactList, fileInput);
            System.out.println("Contact list has been loaded");
            openContactListMenu(appContactList);
        } catch (IOException | IllegalStateException e) {
            System.out.println("Something went wrong when loading the file. Returning to main menu...");
            openContactMainMenu();
        } catch (NoSuchElementException ex) {
            System.out.println("That file does not exist or could not be found. Returning to main menu...");
            openContactMainMenu();
        }
    }

    private static void loadContactListFromFile(ContactList appContactList, Scanner fileInput) {
        fileInput.useDelimiter("\u200b");
        while (fileInput.hasNext()) {
            appContactList.addContactItem(createContactItemFromFile(appContactList, fileInput));
        }
        /*
        How to use delimiter:
        The default delimiter is space. When you do scan.next, it reads until it reaches space.
        Now it will read until it reaches "\u200b" which is the zero-width-space character.
         */

    }

    private static ContactItem createContactItemFromFile(ContactList appContactList, Scanner fileInput) {
        //This section could be made "simpler" if I instead only using fileInput.next() to scan in everything
        //then continued to use the substring shortening method to make things the right size
        //but this would require a lot of trial and error and would break if the printing format changes
        //by even a single character

        //Reads up to the first ZWSP to throw out the task number and name prefix.
        fileInput.next();

        //CHECK: This section might not be working correctly. Check it closely.
        //Reads in "Name " then shortens it to "Name"
        String firstName = fileInput.next();
        firstName = firstName.substring(0, firstName.length() - 1);

        //Reads in "LName"
        String lastName = fileInput.nextLine();

        //Reads up to the ZWSP right before phone# to throw out the phone prefix.
        fileInput.next();

        //Reads in Phone
        String phone = fileInput.nextLine();

        //Reads up to the ZWSP right before Email to throw out the email prefix.
        fileInput.next();

        //Reads in Email
        String email = fileInput.nextLine();

        return new ContactItem(firstName, lastName, phone, email);
    }

    private static void openContactListMenu(ContactList appContactList) {
        int response;
        while (true) {
            printContactListMenu();
            response = scan.nextInt();
            scan.nextLine();

            switch (response) {
                case 1 -> viewContactList(appContactList);
                case 2 -> addAContact(appContactList);
                case 3 -> editAContact(appContactList);
                case 4 -> removeAContact(appContactList);
                case 5 -> SaveCurrentContactList(appContactList);
                case 6 -> openContactMainMenu();
                default -> System.out.println("I'm not sure I understood that. Please enter a number from 1-8\n");
            }
        }
    }

    private static void viewContactList(ContactList appContactList) {
        System.out.println("Current Contacts\n" + "-------------\n\n" + appContactList);
    }

    private static void addAContact(ContactList appContactList) {
        ContactItem appContactItem = new ContactItem();

        System.out.println("First name: ");
        appContactItem.setFirstName(scan.nextLine());

        System.out.println("Last name: ");
        appContactItem.setLastName(scan.nextLine());

        System.out.println("Phone number (xxx-xxx-xxxx): ");
        appContactItem.setPhoneNumber(scan.nextLine());

        //The only error which should be handles is if all fields are empty
        //If the previous 3 fields were empty, and now email is also empty, this will trigger an exception
        //If any of the previous 3 were not empty, the exception will not be triggered
        //Therefore I should only need a try catch on the last field being taken in
        System.out.println("Email address (x@y.z): ");
        try {
            appContactItem.setEmail(scan.nextLine());
        } catch (IllegalArgumentException ex) {
            System.out.println("Sorry, contacts may not be completely empty. Returning to list menu...");
            openContactListMenu(appContactList);
            return;
        }
        appContactList.addContactItem(appContactItem);
    }

    private static void editAContact(ContactList appContactList) {
        //Check assumption: If a change would make a contact empty, it is not allowed to go through.
        //If an error occurs, changes made before that error will be maintained.
        if (appContactList.size() == 0) {
            System.out.println("Sorry, there's nothing to edit. Returning to list menu...");
            openContactListMenu(appContactList);
        } else {
            viewContactList(appContactList);

            System.out.println("Which contact will you edit? ");
            int userChoice = scan.nextInt();
            scan.nextLine();
            if ((userChoice > (appContactList.size() - 1)) || userChoice < 0) {
                System.out.println("Whoops, your choice should be one of the items on the list. Returning to list " +
                        "menu...");
                openContactListMenu(appContactList);
            } else {
                System.out.println("Enter a new first name for contact " + userChoice + ": ");
                try {
                    appContactList.editContactItemFirstName(scan.nextLine(), userChoice);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Whoops, an error occurred. Contacts may not be empty. Returning to list menu." +
                            "..");
                    openContactListMenu(appContactList);
                    return;
                }

                System.out.println("Enter a new last name for contact " + userChoice + ": ");
                try {
                    appContactList.editContactItemLastName(scan.nextLine(), userChoice);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Whoops, an error occurred. Contacts may not be empty. Returning to list menu." +
                            "..");
                    openContactListMenu(appContactList);
                    return;
                }

                System.out.println("Enter a new phone number for contact " + userChoice + ": ");
                try {
                    appContactList.editContactItemPhone(scan.nextLine(), userChoice);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Whoops, an error occurred. Contacts may not be empty. Returning to list menu." +
                            "..");
                    openContactListMenu(appContactList);
                    return;
                }

                System.out.println("Enter a new email for contact " + userChoice + ": ");
                try {
                    appContactList.editContactItemEmail(scan.nextLine(), userChoice);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Whoops, an error occurred. Contacts may not be empty. Returning to list menu." +
                            "..");
                    openContactListMenu(appContactList);
                }
            }
        }
    }

    private static void removeAContact(ContactList appContactList) {
        if (appContactList.size() == 0) {
            System.out.println("Sorry, there's nothing to remove. Returning to list menu...");
            openContactListMenu(appContactList);
        } else {
            viewContactList(appContactList);

            System.out.println("Which contact will you remove? ");
            int userChoice = scan.nextInt();
            scan.nextLine();
            if ((userChoice > (appContactList.size() - 1)) || userChoice < 0) {
                System.out.println("Whoops, your choice should be one of the items on the list. Returning to list " +
                        "menu...");
                openContactListMenu(appContactList);
            } else {
                appContactList.removeContactItem(userChoice);
            }
        }
    }

    private static void SaveCurrentContactList(ContactList appContactList) {
        //All of this error checking for .txt could be removed if I just append .txt to the end of whatever the user
        //inputs but I think this is better to prevent the user from creating files called tasks.txt.txt accidentally
        if (appContactList.size() == 0) {
            System.out.println("Sorry, there's nothing to save. Returning to list menu...");
            openContactListMenu(appContactList);
        } else {
            System.out.println("Enter the filename to save as (must end in .txt and not be empty): ");
            String outputFileName = scan.nextLine();
            if (outputFileName.startsWith(".txt", outputFileName.length() - 4)) {
                if (outputFileName.length() > 4) {
                    try (Formatter output = new Formatter(outputFileName)) {
                        output.format(appContactList + "");
                        System.out.println("Contact list has been saved successfully.\n");
                    } catch (SecurityException | FileNotFoundException | FormatterClosedException ex) {
                        System.out.println("Something went wrong while trying to save the list. Returning to list " +
                                "menu...");
                        openContactListMenu(appContactList);
                    }
                } else {
                    System.out.println("Filenames may not be blank");
                }
            } else {
                System.out.println("Filenames must end with .txt");
            }
        }
    }

    private static void printContactMainMenu() {
        System.out.println("Main Menu\n---------\n");
        System.out.println("1) Create a new contact list");
        System.out.println("2) Load an existing contact list");
        System.out.println("3) Quit");
    }

    private static void printContactListMenu() {
        System.out.println("List Operation Menu\n---------\n");
        System.out.println("1) View the contact list");
        System.out.println("2) Add a contact");
        System.out.println("3) Edit a contact");
        System.out.println("4) Remove a contact");
        System.out.println("5) Save the current list");
        System.out.println("6) Quit to the main menu");
    }

}
