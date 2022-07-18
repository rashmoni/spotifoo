import java.util.ArrayList;
import java.util.List;

public class MenuController {
    //function to print menu
    public void printMenu(List<String> options, String menuType) {

        //clear the screen before any menu
        ClearScreen cls = new ClearScreen();
        cls.ClearConsole();

        //Welcome message
        System.out.println("Welcome to Spotifoo music player!");
        System.out.println();

        System.out.println(menuType);

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
    public void mainMenu() {

        //Options for main menu
        List<String> mainMenuOptions = new ArrayList<>();
        mainMenuOptions.add("Songs");
        mainMenuOptions.add("Artists");
        mainMenuOptions.add("Albums");
        mainMenuOptions.add("Genres");
        mainMenuOptions.add("Search");

        //choice variable
        int choice;

        //Display menu
        printMenu(mainMenuOptions, "mainMenu");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose an option and press enter: ",
                "\u26A0 Not a valid option", 1, 5);

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
        } else
            mainMenu();
    }

    public void songsMenu() {

        //Options for songs menu
        List<String> songsMenuOptionlist;

        GetItemsFromData songsList = new GetItemsFromData();
        songsMenuOptionlist = songsList.getSongs();


        //Display menu
        printMenu(songsMenuOptionlist, "songsMenu");

        //choice variable
        int choice;

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose a song to play:",
                "Choose a valid song or enter 0 to go back", 0, songsMenuOptionlist.size());

        if (choice == 0) {
            mainMenu();
        } else {

            List fileList = new ArrayList();
            fileList = songsList.getFilesForSong(songsMenuOptionlist.get(choice - 1));

            PlaySong play = new PlaySong();
            play.playSong(songsMenuOptionlist.get(choice - 1), (String)fileList.get(0), (String)fileList.get(1));

        }

    }

    public void artistsMenu() {

        //Options for songs menu
        List<String> artistMenuOptionslist;

        // Filtered songs list based on artist
        List<String> artistSongsOptionslist;

        GetItemsFromData artistsList = new GetItemsFromData();
        artistMenuOptionslist = artistsList.getArtist();

        //Display menu
        printMenu(artistMenuOptionslist, "artistMenu");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an artist :",
                "Choose a valid artist or enter 0 to go back", 0, artistMenuOptionslist.size());

        if (choice != 0) {
            artistSongsOptionslist = artistsList.getSongs("artist", artistMenuOptionslist.get(choice - 1));
            printMenu(artistSongsOptionslist, "artistMenu");

            //Assign user input to choice variable using the readInteger function
            choice = input.readInteger("Choose a song to play or select 0 to go back:",
                    "Choose a valid artist or enter 0 to go back", 0, artistSongsOptionslist.size());

            if (choice == 0) {
                mainMenu();
            } else {
                List fileList = new ArrayList();
                fileList = artistsList.getFilesForSong(artistSongsOptionslist.get(choice - 1));

                PlaySong play = new PlaySong();
                play.playSong(artistSongsOptionslist.get(choice - 1), (String)fileList.get(0), (String)fileList.get(1));

            }
        } else
            mainMenu();
    }


    public void albumsMenu() {


        //Options for songs menu
        List<String> albumMenuOptionslist;

        // Filtered songs list based on albums
        List<String> albumsSongsOptionslist;

        GetItemsFromData albumsList = new GetItemsFromData();
        albumMenuOptionslist = albumsList.getAlbums();

        //Display menu
        printMenu(albumMenuOptionslist, "albumsMenu");


        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an album or enter 0 to go back:",
                "Choose a valid album or enter 0 to go back", 0, albumMenuOptionslist.size());

        if (choice != 0) {
            albumsSongsOptionslist = albumsList.getSongs("albums", albumMenuOptionslist.get(choice - 1));
            printMenu(albumsSongsOptionslist, "albumsMenu");
            //Assign user input to choice variable using the readInteger function
            choice = input.readInteger("Choose a song to play or select 0 to go back:",
                    "Choose a valid album or enter 0 to go back", 0, albumsSongsOptionslist.size());
            if (choice == 0) {
                mainMenu();
            } else {
                List fileList = new ArrayList();
                fileList = albumsList.getFilesForSong(albumsSongsOptionslist.get(choice - 1));

                PlaySong play = new PlaySong();
                play.playSong(albumsSongsOptionslist.get(choice - 1), (String)fileList.get(0), (String)fileList.get(1));

            }
        } else
            mainMenu();
    }

    public void genresMenu() {

        List<String> genresMenuOptionslist;

        // Filtered songs list based on albums
        List<String> genresSongsOptionslist;

        GetItemsFromData genresList = new GetItemsFromData();
        genresMenuOptionslist = genresList.getGenres();

        //Display menu
        printMenu(genresMenuOptionslist, "genresMenu");

        //choice variable
        int choice;

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        choice = input.readInteger("Choose an genres :",
                "Choose a valid genres or enter 0 to go back", 0, genresMenuOptionslist.size());

        if (choice != 0) {
            genresSongsOptionslist = genresList.getSongs("genres", genresMenuOptionslist.get(choice - 1));
            printMenu(genresSongsOptionslist, "genresMenu");
            //Assign user input to choice variable using the readInteger function
            choice = input.readInteger("Choose a song to play or select 0 to go back:",
                    "Choose a valid genres or enter 0 to go back", 0, genresSongsOptionslist.size());
            if (choice == 0) {
                mainMenu();
            } else {
                List fileList = new ArrayList();
                fileList = genresList.getFilesForSong(genresSongsOptionslist.get(choice - 1));

                PlaySong play = new PlaySong();
                play.playSong(genresSongsOptionslist.get(choice - 1), (String)fileList.get(0), (String)fileList.get(1));

            }
        }
        else mainMenu();
    }


    public void searchMenu() {

        Search search1 = new Search();

        List<String> searchedSongslist = search1.searchSongs();


        if (searchedSongslist!=null) {
            printMenu(searchedSongslist, "searchMenu");
        }
        else mainMenu();

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose a song to play or select 0 to go back:",
                "Invalid Entry, choose a song or enter 0 to go back", 0, searchedSongslist.size());
        if (choice == 0) {
            mainMenu();
        } else {
            List fileList = new ArrayList();

            GetItemsFromData songsList = new GetItemsFromData();
            fileList = songsList.getFilesForSong(searchedSongslist.get(choice - 1));
            PlaySong play = new PlaySong();
            play.playSong(searchedSongslist.get(choice - 1), (String)fileList.get(0), (String)fileList.get(1));

        }


    }

}





