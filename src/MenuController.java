import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    //function to print menu
    public void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
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

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose an option and press enter:",
                "!Not a valid option", 1, 5);

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

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose a song to play:",
                "Choose a valid song or enter 0 to go back", 0, 1);

        if (choice == 0) {
            mainMenu();
        } else {
            System.out.println("playing song ");
            songsMenu();
        }


    }


    public void artistsMenu() {
        System.out.println("You are in artistsMenu");
        String[] artistMenuOptions = {"[1] Sonu", "[0] Back to main menu"};

        //Display menu
        printMenu(artistMenuOptions);

        //choice variable
        int choice;
        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose an artist :",
                "Choose a valid artist or enter 0 to go back", 0, 1);

        if (choice == 0) {
            mainMenu();
        } else {
            System.out.println("playing song with artist filter");
            songsMenu();
        }
    }



    public void albumsMenu() {
        System.out.println("You are in albumsMenu");
        String[] albumsMenuOptions = {"[1] Best of Sonu", "[0] Back to main menu"};

        //Display menu
        printMenu(albumsMenuOptions);

        //choice variable
        int choice;

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose an album :",
                "Choose a valid album or enter 0 to go back", 0, 1);

        if (choice == 0) {
            mainMenu();
        } else {
            System.out.println("playing song with album menu");
            songsMenu();

        }
    }

    public void genresMenu() {
        System.out.println("You are in genresMenu");
        String[] genresMenuOptions = {"[1] Sad song of Sonu", "[0] Back to main menu"};

        //Display menu
        printMenu(genresMenuOptions);

        //choice variable
        int choice;
        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose an genres :",
                "Choose a valid genres or enter 0 to go back", 0, 1);

        if (choice == 0) {
            mainMenu();
        } else {
            System.out.println("playing song with genres menu");
            songsMenu();
        }
    }


    public void searchMenu() {
        System.out.println("You are in searchMenu");


        }

    }





