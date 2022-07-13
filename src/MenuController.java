import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    //function to print menu
    public void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose an option and press enter:");
    }

    //main menu
    public void mainMenu() {
        //Message for main menu
        System.out.println("Main menu options:");

        //Options for main menu
        String[] mainMenuOptions = {"[1] Songs", "[2] Artists", "[3] Albums", "[4] Genres", "[5] Search"};

        //choice variable
        int choice = 0;

        //Display menu
        printMenu(mainMenuOptions);

        //scanner to get user input
        Scanner in = new Scanner(System.in);

        //Assign user input to choice variable
        choice = in.nextInt();

        //To do after user selection
        while (choice!=0) {
            switch (choice) {
                case 1:
                    songsMenu();
                    break;
                case 2:
                    artistsMenu();
                    break;
                case 3:
                    albumsMenu();
                    break;
                case 4:
                    genresMenu();
                    break;
                case 5:
                    searchMenu();
                    break;
                default:
                    System.out.println("Not a valid option, please select from below list");
                    mainMenu();
            }
        }


    }

    public void songsMenu() {
        System.out.println("Songs menu Options : ");
        //Options for songs menu
        String[] songsMenuOptions = {"[1] Ha ha Song","[0] Back to main menu" };

        //Display menu
        printMenu(songsMenuOptions);

        //choice variable
        int choice;
        //scanner to get user input
        Scanner in = new Scanner(System.in);

        //Assign user input to choice variable
        choice = in.nextInt();
        if(choice==0){
            mainMenu();
            }
        else {
            System.out.println("playing song.....");
            songsMenu();
        }
    }


    public void artistsMenu() {
        System.out.println("You are in artistsMenu");

    }

    public void albumsMenu() {
        System.out.println("You are in albumsMenu");

    }

    public void genresMenu() {
        System.out.println("You are in genresMenu");

    }
    public void searchMenu() {
        System.out.println("You are in searchMenu");

    }

}

