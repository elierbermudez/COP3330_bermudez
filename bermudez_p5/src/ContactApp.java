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
    /*
    Extra Functions:
A contact list shall contain 1 or more contact items

A contact item shall contain a first name
A contact item shall contain a last name
A contact item shall contain a phone number
A contact item shall contain an email address
A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]

A user shall be able to create a new contact list
A user shall be able to load an existing contact list
A user shall be able to view the current contact list
A user shall be able to save the current contact list
A user shall be able to add a contact to the current contact list
A user shall be able to edit a contact in the current contact list
A user shall be able to remove a contact from the current contact list
     */
    //All of this is copy pasted over from TaskApp, none of it will function properly for ContactApp
    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        openMainMenu();
    }

    private static void openMainMenu() {
        int response;
        while (true) {
            printMainMenu();
            response = scan.nextInt();
            scan.nextLine();

            switch (response) {
                case 1 -> {
                    System.out.println("New task list has been created\n");
                    TaskList appTaskList = new TaskList();
                    openListMenu(appTaskList);
                }
                case 2 -> {
                    openLoadMenu();
                }
                case 3 -> {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
                default -> System.out.println("I'm not sure I understood that. Please enter the number 1, 2, or 3\n");
            }
        }
    }

    private static void openLoadMenu() {
        System.out.println("Enter the filename to load:");
        String filename = scan.nextLine();
        TaskList appTaskList = new TaskList();

        try (Scanner fileInput = new Scanner(Paths.get(filename))) {
            loadTaskListFromFile(appTaskList, fileInput);
            System.out.println("Task list has been loaded");
            openListMenu(appTaskList);
        } catch (IOException | IllegalStateException e) {
            System.out.println("Something went wrong when loading the file. Returning to main menu...");
            openMainMenu();
        } catch (NoSuchElementException ex) {
            System.out.println("That file does not exist or could not be found. Returning to main menu...");
            openMainMenu();
        }
    }

    private static void loadTaskListFromFile(TaskList appTaskList, Scanner fileInput) {
        fileInput.useDelimiter("\u200b");
        while (fileInput.hasNext()) {
            appTaskList.addTaskItem(createTaskItemFromFile(appTaskList, fileInput));
        }
        /*
        How to use delimiter:
        The default delimiter is space. When you do scan.next, it reads until it reaches space.
        Now it will read until it reaches "\u200b" which is the zero-width-space character.
         */

    }

    private static TaskItem createTaskItemFromFile(TaskList appTaskList, Scanner fileInput) {
        //Reads up to the first ZWSP to throw out the task number.
        fileInput.next();

        //Reads in "+ [" or "- [" then shorten it to just + or -
        String completedSymbol = fileInput.next().substring(0, 1);

        //Reads in "1111-11-11] " then shortens it to 1111-11-11
        String dueDate = fileInput.next().substring(0, 10);

        //Reads in "title 1 with spaces: " then shortens it to "title 1 with spaces"
        String title = fileInput.next();
        title = title.substring(0, title.length() - 2);

        //Reads in "description 1 with spaces"
        String description = fileInput.next();

        //Reads the end of line terminator.
        fileInput.nextLine();

        TaskItem tempItem = new TaskItem(dueDate, title, description);

        if (completedSymbol.equals("+")) {
            tempItem.setCompleted();
        }

        return tempItem;
    }

    private static void openListMenu(TaskList appTaskList) {
        int response;
        while (true) {
            printListMenu();
            response = scan.nextInt();
            scan.nextLine();

            switch (response) {
                case 1 -> {
                    viewTaskList(appTaskList);
                }
                case 2 -> {
                    addATask(appTaskList);
                }
                case 3 -> {
                    editATask(appTaskList);
                }
                case 4 -> {
                    removeATask(appTaskList);
                }
                case 5 -> {
                    markATaskComplete(appTaskList);
                }
                case 6 -> {
                    markATaskIncomplete(appTaskList);
                }
                case 7 -> {
                    SaveCurrentList(appTaskList);
                }
                case 8 -> {
                    openMainMenu();
                }
                default -> System.out.println("I'm not sure I understood that. Please enter a number from 1-8\n");
            }
        }
    }

    private static void viewTaskList(TaskList appTaskList) {
        System.out.println("Current Tasks\n" + "-------------\n\n" + appTaskList);
    }

    private static void viewUncompletedTaskList(TaskList appTaskList) {
        if (appTaskList.getUncompletedTaskItemsAsString().equals("")) {
            throw new IllegalArgumentException();
        } else {
            System.out.println("Current Tasks\n" + "-------------\n\n" + appTaskList.getUncompletedTaskItemsAsString());
        }
    }

    private static void viewCompletedTaskList(TaskList appTaskList) {
        if (appTaskList.getCompletedTaskItemsAsString().equals("")) {
            throw new IllegalArgumentException();
        } else {
            System.out.println("Current Tasks\n" + "-------------\n\n" + appTaskList.getCompletedTaskItemsAsString());
        }
    }

    private static void addATask(TaskList appTaskList) {
        TaskItem appTaskItem = new TaskItem();

        System.out.println("Task title: ");
        try {
            appTaskItem.setTitle(scan.nextLine());
        } catch (IllegalArgumentException ex) {
            System.out.println("Whoops, task titles may not be empty. Returning to list menu...");
            openListMenu(appTaskList);
            return;
        }

        System.out.println("Task description: ");
        appTaskItem.setDescription(scan.nextLine());

        System.out.println("Task due date (YYYY-MM-DD): ");
        try {
            appTaskItem.setDueDate(scan.nextLine());
        } catch (IllegalArgumentException ex) {
            System.out.println("Whoops, task due dates must be in the format (YYYY-MM-DD). Returning to list menu...");
            openListMenu(appTaskList);
        }
        appTaskList.addTaskItem(appTaskItem);
    }

    private static void editATask(TaskList appTaskList) {
        //I decided to program this so that if the user gives bad input on the last section
        //Then it will still keep the changes that they made on the first 2 sections.
        //In real world application it would be annoying to type out a very long task description
        //Then lose everything because you typed the date wrong.
        if (appTaskList.size() == 0) {
            System.out.println("Sorry, there's nothing to edit. Returning to list menu...");
            openListMenu(appTaskList);
        } else {
            viewTaskList(appTaskList);

            System.out.println("Which task will you edit? ");
            int userChoice = scan.nextInt();
            scan.nextLine();
            if ((userChoice > (appTaskList.size() - 1)) || userChoice < 0) {
                System.out.println("Whoops, your choice should be one of the items on the list. Returning to list menu...");
                openListMenu(appTaskList);
            } else {
                System.out.println("Enter a new title for task " + userChoice + ": ");
                try {
                    appTaskList.editTaskItemTitle(scan.nextLine(), userChoice);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Whoops, task titles may not be empty. Returning to list menu...");
                    openListMenu(appTaskList);
                    return;
                }

                System.out.println("Enter a new description for task " + userChoice + ": ");
                appTaskList.editTaskItemDescription(scan.nextLine(), userChoice);

                System.out.println("Enter a new task due date (YYYY-MM-DD) for task " + userChoice + ": ");
                try {
                    appTaskList.editTaskItemDueDate(scan.nextLine(), userChoice);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Whoops, task due dates must be in the format (YYYY-MM-DD). Returning to list menu...");
                    openListMenu(appTaskList);
                }
            }
        }
    }

    private static void removeATask(TaskList appTaskList) {
        if (appTaskList.size() == 0) {
            System.out.println("Sorry, there's nothing to remove. Returning to list menu...");
            openListMenu(appTaskList);
        } else {
            viewTaskList(appTaskList);

            System.out.println("Which task will you remove? ");
            int userChoice = scan.nextInt();
            scan.nextLine();
            if ((userChoice > (appTaskList.size() - 1)) || userChoice < 0) {
                System.out.println("Whoops, your choice should be one of the items on the list. Returning to list menu...");
                openListMenu(appTaskList);
            } else {
                appTaskList.removeTaskItem(userChoice);
            }
        }
    }

    private static void markATaskComplete(TaskList appTaskList) {
        if (appTaskList.size() == 0) {
            System.out.println("Sorry, there's nothing to mark complete. Returning to list menu...");
            openListMenu(appTaskList);
        } else {
            try {
                viewUncompletedTaskList(appTaskList);
            } catch (IllegalArgumentException ex) {
                System.out.println("Looks like you finished everything! Good job! Returning to list menu...");
                openListMenu(appTaskList);
            }

            System.out.println("Which task will you mark as complete? ");
            int userChoice = scan.nextInt();
            scan.nextLine();
            if ((userChoice > (appTaskList.size() - 1)) || userChoice < 0) {
                System.out.println("Whoops, your choice should be one of the items on the list. Returning to list menu...");
                openListMenu(appTaskList);
            } else {
                appTaskList.completeTaskItem(userChoice);
            }
        }
    }

    private static void markATaskIncomplete(TaskList appTaskList) {
        if (appTaskList.size() == 0) {
            System.out.println("Sorry, there's nothing to mark incomplete. Returning to list menu...");
            openListMenu(appTaskList);
        } else {
            try {
                viewCompletedTaskList(appTaskList);
            } catch (IllegalArgumentException ex) {
                System.out.println("Looks like you haven't completed anything yet. Returning to list menu...");
                openListMenu(appTaskList);
            }
            System.out.println("Which task will you mark as incomplete? ");
            int userChoice = scan.nextInt();
            scan.nextLine();
            if ((userChoice > (appTaskList.size() - 1)) || userChoice < 0) {
                System.out.println("Whoops, your choice should be one of the items on the list. Returning to list menu...");
                openListMenu(appTaskList);
            } else {
                appTaskList.uncompleteTaskItem(userChoice);
            }
        }
    }

    private static void SaveCurrentList(TaskList appTaskList) {
        //All of this error checking for .txt could be removed if I just append .txt to the end of whatever the user
        //inputs but I think this is better to prevent the user from creating files called tasks.txt.txt accidentally
        if (appTaskList.size() == 0) {
            System.out.println("Sorry, there's nothing to save. Returning to list menu...");
            openListMenu(appTaskList);
        } else {
            System.out.println("Enter the filename to save as (must end in .txt and not be empty): ");
            String outputFileName = scan.nextLine();
            if (outputFileName.substring(outputFileName.length() - 4, outputFileName.length()).equals(".txt")) {
                if (outputFileName.length() > 4) {
                    try (Formatter output = new Formatter(outputFileName)) {
                        output.format(appTaskList + "");
                        System.out.println("Task list has been saved successfully.\n");
                    } catch (SecurityException | FileNotFoundException | FormatterClosedException ex) {
                        System.out.println("Something went wrong while trying to save the list. Returning to list menu...");
                        openListMenu(appTaskList);
                    }
                } else {
                    System.out.println("Filenames may not be blank");
                }
            } else {
                System.out.println("Filenames must end with .txt");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("Main Menu\n---------\n");
        System.out.println("1) Create a new task list");
        System.out.println("2) Load an existing task list");
        System.out.println("3) Quit");
    }

    private static void printListMenu() {
        System.out.println("List Operation Menu\n---------\n");
        System.out.println("1) View the task list");
        System.out.println("2) Add a task");
        System.out.println("3) Edit a task");
        System.out.println("4) Remove a task");
        System.out.println("5) Mark a task as complete");
        System.out.println("6) Mark a task as incomplete");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to the main menu");
    }

}
