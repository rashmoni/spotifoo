import java.util.ArrayList;
import java.util.List;

public class Application {
    static final String CHOOSESONG = "Choose a song to play or select 0 to go back:";
    static final String CANNOTPLAYSONG = "\u274c Cannot play this song, choose another song";
    static final String CHOOSEVALIDSONG = "\u26A0 Choose a valid song or enter 0 to go back";
    Boolean Exit = false;
    //main menu
    public void mainMenu() {

        //Options for main menu
        List<String> mainMenuOptions = new ArrayList<>();
        mainMenuOptions.add("Songs");
        mainMenuOptions.add("Artists");
        mainMenuOptions.add("Albums");
        mainMenuOptions.add("Genres");
        mainMenuOptions.add("Search");


        while (!Exit) {
            //Print menu
            printMenu(mainMenuOptions, "mainMenu");

            //UserInput class to verify and get only valid user input
            UserInput input = new UserInput();

            //Assign user input to choice variable using the readInteger function
            int choice = input.readInteger("Choose an option and press enter: ", "\u26A0 Not a valid option", 1, 5);

            //To do after user selection
            if (choice == 1) {
                songsMenu();
            } else if (choice == 2) {
                artistsMenu();
            } else if (choice == 3) {
                albumsMenu();
            } else if (choice == 4) {
                genresMenu();
            } else if (choice == 5) {
                searchMenu();
            }
        }
    }

    public void songsMenu() {

        GetItemsFromData itemObject = new GetItemsFromData();
        List<String> songlist = itemObject.getSongs();
        subMenu(songlist);
    }

    public void artistsMenu() {

        GetItemsFromData itemObject = new GetItemsFromData();
        List<String> generalList = itemObject.getArtist();

        //Display artist menu
        printMenu(generalList, "artist available:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an artist :", "\u26A0 Choose a valid artist or enter 0 to go back", 0, generalList.size());

        if (choice != 0) {
            List<String> songList = itemObject.getSongs("artist", generalList.get(choice - 1));
            subMenu(songList);
        }
    }


    public void albumsMenu() {

        GetItemsFromData itemObject = new GetItemsFromData();
        List<String> generalList = itemObject.getAlbums();

        //Display album menu
        printMenu(generalList, "album available:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an album or enter 0 to go back:", "\u26A0 Choose a valid album or enter 0 to go back", 0, generalList.size());

        if (choice != 0) {
            List<String> songList = itemObject.getSongs("albums", generalList.get(choice - 1));
            subMenu(songList);
        }
    }

    public void genresMenu() {

        GetItemsFromData itemObject = new GetItemsFromData();
        List<String> generalList = itemObject.getGenres();
        //Display menu
        printMenu(generalList, "Genre available:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an genres :", "\u26A0 Choose a valid genres or enter 0 to go back", 0, generalList.size());

        if (choice != 0) {
            List<String> songList = itemObject.getSongs("genres", generalList.get(choice - 1));
            subMenu(songList);
        }
    }


    public void searchMenu() {
        Search search1 = new Search();
        List<String> songList = search1.searchSongs();
        printMenu(songList, "Search for a song:");
        subMenu(songList);
    }

    //function to print menu
    public void printMenu(List<String> options, String menuType) {

        //clear the screen before any menu
        ClearScreen cls = new ClearScreen();
        cls.clearConsole();

        //Welcome message
        System.out.println("Welcome to Spotifoo music player!");
        System.out.println();

        int i = 1;
        if (menuType.equalsIgnoreCase("mainMenu")) {
            System.out.println("Main menu options:");
            for (String option : options) {
                System.out.println("[" + i + "]" + " " + option);
                i++;
            }
        } else {
            System.out.println(menuType);
            for (String option : options) {
                System.out.println("[" + i + "]" + " " + option);
                i++;
            }
            System.out.println("[0] Go back to main menu");
        }
    }


    public void subMenu(List<String> songList) {
        GetItemsFromData itemObject = new GetItemsFromData();
        //Print menu
        printMenu(songList, "Songs available:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger(CHOOSESONG, CHOOSEVALIDSONG, 0, songList.size());

        if (choice != 0) {
            List<String> fileList = itemObject.getFilesForSong(songList.get(choice - 1));

            PlaySong play = new PlaySong();
            boolean playSuccess = play.playSong(fileList.get(0), fileList.get(1));
            Exit = true;
            while (!playSuccess) {
                System.out.println(CANNOTPLAYSONG);
                choice = input.readInteger(CHOOSESONG, CHOOSEVALIDSONG, 0, songList.size());
                if (choice != 0) {
                    fileList = itemObject.getFilesForSong(songList.get(choice - 1));
                    playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                } else {
                    Exit = false;
                    break;
                }
            }
        }

    }

}
