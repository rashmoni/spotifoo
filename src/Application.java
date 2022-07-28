import java.util.ArrayList;
import java.util.List;

public class Application {
    DisplayController cls = new DisplayController();
    PlayController player = new PlayController();
    GetItemsFromData itemObject = new GetItemsFromData();
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

        // loop until Exit = true
        while (!Exit) {
            //Print menu
            cls.printMenu(mainMenuOptions, "mainMenu");

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
        List<String> songlist = itemObject.getSongs();
        Exit = player.startPlay(songlist);
    }

    public void artistsMenu() {
        List<String> generalList = itemObject.getArtist();
        //Display artist menu
        cls.printMenu(generalList, "artist available:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an artist :", "\u26A0 Choose a valid artist or enter 0 to go back", 0, generalList.size());

        if (choice != 0) {
            List<String> songList = itemObject.getSongs("artist", generalList.get(choice - 1));
            Exit = player.startPlay(songList);
        }
    }

    public void albumsMenu() {
        List<String> generalList = itemObject.getAlbums();

        //Display album menu
        cls.printMenu(generalList, "album available:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an album or enter 0 to go back:", "\u26A0 Choose a valid album or enter 0 to go back", 0, generalList.size());

        if (choice != 0) {
            List<String> songList = itemObject.getSongs("albums", generalList.get(choice - 1));
            Exit = player.startPlay(songList);
        }
    }

    public void genresMenu() {
        List<String> generalList = itemObject.getGenres();

        //Display menu
        cls.printMenu(generalList, "Genre available:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an genres :", "\u26A0 Choose a valid genres or enter 0 to go back", 0, generalList.size());

        if (choice != 0) {
            List<String> songList = itemObject.getSongs("genres", generalList.get(choice - 1));
            Exit = player.startPlay(songList);
        }
    }

    public void searchMenu() {
        List<String> songList = itemObject.searchSongs();
        cls.printMenu(songList, "Search for a song:");
        Exit = player.startPlay(songList);
    }

}
