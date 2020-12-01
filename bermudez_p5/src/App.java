import java.util.Scanner;

public class App {
    private static Scanner scanOutside;

    public static void main(String[] args) {
        scanOutside = new Scanner(System.in);
        openApplicationMainMenu();
    }

    public static void openApplicationMainMenu() {
        int response;
        while (true) {
            printApplicationMainMenu();
            response = scanOutside.nextInt();
            scanOutside.nextLine();

            switch (response) {
                case 1 -> TaskApp.mainTask();
                case 2 -> ContactApp.mainContact();
                case 3 -> {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
                default -> System.out.println("I'm not sure I understood that. Please enter the number 1, 2, or 3\n");
            }
        }
    }

    private static void printApplicationMainMenu() {
        System.out.println("Select Your Application\n-----------------------\n");
        System.out.println("1) Task List");
        System.out.println("2) Contact List");
        System.out.println("3) Quit");
    }
}