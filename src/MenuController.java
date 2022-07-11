import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {

    public void printMenu(String[] options) {
        System.out.println("Main menu Options : ");
        System.out.println("======================");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public void mainMenu() {
        String[] mainMenuOptions = {"[1] Songs", "[2] Artists", "[3] Albums", "[4] Genres", "[5] Search"};
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (true) {
            printMenu(mainMenuOptions);
            try {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 1 and " + mainMenuOptions.length);
                scanner.next();
            }
        }

    }
}
