import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    //function to print menu
    public void printMenu(List<String> options, String menuType) {
        int i = 1;
        if (menuType.equalsIgnoreCase("mainMenu")) {
            for (String option : options) {
                System.out.println("[" + i + "]" + " " + option);
                i++;
            }
        } else {
            for (String option : options) {
                System.out.println("[" + i + "]" + " " + option);
                i++;
            }
            System.out.println("[0] Go back to main menu");
        }
    }

    //main menu
    public void mainMenu() throws IOException {
        //Message for main menu
        System.out.println("Main menu options:");

        //Options for main menu
        List<String> mainMenuOptions = new ArrayList<>();
        mainMenuOptions.add("Songs");
        mainMenuOptions.add("Artists");
        mainMenuOptions.add("Albums");
        mainMenuOptions.add("Genres");
        mainMenuOptions.add("Search");

        //choice variable
        int choice = 0;

        //Display menu
        printMenu(mainMenuOptions, "mainMenu");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose an option and press enter:",
                "!Not a valid option", 1, 5);

        //To do after user selection
        while (choice != 0) {
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

    public void songsMenu() throws IOException {

        System.out.println("Songs menu Options : ");
        //Options for songs menu
        List<String> songsMenuOptionslist = new ArrayList<String>();

        ReadDataFromTextFile rd = new ReadDataFromTextFile();
        songsMenuOptionslist = rd.getData("songs");

        //Conver songsMenuOptionslist to String array
        // String[] songsMenuOptions = songsMenuOptionslist.toArray(new String[0]);

        //Display menu
        printMenu(songsMenuOptionslist, "songsMenu");

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

    public void artistsMenu() throws IOException {
        System.out.println("You are in artistsMenu");
        //Options for songs menu
        List<String> artistMenuOptionslist = new ArrayList<String>();

        ReadDataFromTextFile rd = new ReadDataFromTextFile();
        artistMenuOptionslist = rd.getData("artist");

        //String[] artistMenuOptions = artistMenuOptionslist.toArray(new String[0]);

        //Display menu
        printMenu(artistMenuOptionslist, "artistMenu");

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
            artistsMenu();
        }
    }


    public void albumsMenu() throws IOException {
        System.out.println("You are in albumsMenu");
        //Options for songs menu
        List<String> albumMenuOptionslist = new ArrayList<String>();
        ReadDataFromTextFile rd = new ReadDataFromTextFile();
        albumMenuOptionslist = rd.getData("album");


        //String[] albumsMenuOptions = albumMenuOptionslist.toArray(new String[0]);

        //Display menu
        printMenu(albumMenuOptionslist, "albumsMenu");

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
            albumsMenu();

        }
    }

    public void genresMenu() throws IOException {
        System.out.println("You are in genresMenu");

        List<String> genresMenuOptionslist = new ArrayList<String>();
        ReadDataFromTextFile rd = new ReadDataFromTextFile();
        genresMenuOptionslist = rd.getData("genres");


        // String[] genresMenuOptions = genresMenuOptionslist.toArray(new String[0]);

        //Display menu
        printMenu(genresMenuOptionslist, "genresMenu");

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
            genresMenu();
        }
    }


    public void searchMenu() {
        System.out.println("You are in searchMenu");


    }

}





