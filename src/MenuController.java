import java.util.ArrayList;
import java.util.List;

public class MenuController {
    //main menu
    public void mainMenu() {

        //Options for main menu
        List<String> mainMenuOptions = new ArrayList<>();
        mainMenuOptions.add("Songs");
        mainMenuOptions.add("Artists");
        mainMenuOptions.add("Albums");
        mainMenuOptions.add("Genres");
        mainMenuOptions.add("Search");

        //Display menu
        printMenu(mainMenuOptions, "mainMenu");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an option and press enter: ",
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


        //Print menu
        printMenu(songsMenuOptionlist, "Songs menu:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose a song to play:",
                "\u26A0 Choose a valid song or enter 0 to go back", 0, songsMenuOptionlist.size());

        if (choice == 0) {
            mainMenu();
        } else {

            List<String> fileList = songsList.getFilesForSong(songsMenuOptionlist.get(choice - 1));

            PlaySong play = new PlaySong();
            boolean playSuccess = play.playSong(fileList.get(0), fileList.get(1));

            while (!playSuccess) {
                System.out.println("\u274c Cannot play this song, choose another song");
                choice = input.readInteger("Choose a song to play:",
                        "\u26A0 Choose a valid song or enter 0 to go back", 0, songsMenuOptionlist.size());
                if (choice == 0) {
                    mainMenu();
                } else {
                    fileList = songsList.getFilesForSong(songsMenuOptionlist.get(choice - 1));
                    playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                }
            }

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
        printMenu(artistMenuOptionslist, "artist available:");

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an artist :",
                "\u26A0 Choose a valid artist or enter 0 to go back", 0, artistMenuOptionslist.size());

        if (choice != 0) {
            artistSongsOptionslist = artistsList.getSongs("artist", artistMenuOptionslist.get(choice - 1));
            printMenu(artistSongsOptionslist, "artistMenu");

            //Assign user input to choice variable using the readInteger function
            choice = input.readInteger("Choose a song to play or select 0 to go back:",
                    "Choose a valid artist or enter 0 to go back", 0, artistSongsOptionslist.size());
            if (choice == 0) {
                mainMenu();
            } else {
                List<String> fileList = artistsList.getFilesForSong(artistSongsOptionslist.get(choice - 1));

                PlaySong play = new PlaySong();
                boolean playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                while (!playSuccess) {
                    System.out.println("\u274c Cannot play this song, choose another song");
                    choice = input.readInteger("Choose a song to play:",
                            "\u26A0 Choose a valid song or enter 0 to go back", 0, artistSongsOptionslist.size());
                    if (choice == 0) {
                        mainMenu();
                    } else {
                        fileList = artistsList.getFilesForSong(artistSongsOptionslist.get(choice - 1));
                        playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                    }
                }
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
        printMenu(albumMenuOptionslist, "album available:");


        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an album or enter 0 to go back:",
                "\u26A0 Choose a valid album or enter 0 to go back", 0, albumMenuOptionslist.size());

        if (choice != 0) {
            albumsSongsOptionslist = albumsList.getSongs("albums", albumMenuOptionslist.get(choice - 1));
            printMenu(albumsSongsOptionslist, "albumsMenu");
            //Assign user input to choice variable using the readInteger function
            choice = input.readInteger("Choose a song to play or select 0 to go back:",
                    "Choose a valid album or enter 0 to go back", 0, albumsSongsOptionslist.size());
            if (choice == 0) {
                mainMenu();
            } else {
                List<String> fileList = albumsList.getFilesForSong(albumsSongsOptionslist.get(choice - 1));

                PlaySong play = new PlaySong();
                boolean playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                while (!playSuccess) {
                    System.out.println("\u274c Cannot play this song, choose another song");
                    choice = input.readInteger("Choose a song to play:",
                            "\u26A0 Choose a valid song or enter 0 to go back", 0, albumsSongsOptionslist.size());
                    if (choice == 0) {
                        mainMenu();
                    } else {
                        fileList = albumsList.getFilesForSong(albumsSongsOptionslist.get(choice - 1));
                        playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                    }

                }
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
        printMenu(genresMenuOptionslist, "genre available");


        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose an genres :",
                "\u26A0 Choose a valid genres or enter 0 to go back", 0, genresMenuOptionslist.size());

        if (choice != 0) {
            genresSongsOptionslist = genresList.getSongs("genres", genresMenuOptionslist.get(choice - 1));
            printMenu(genresSongsOptionslist, "genresMenu");
            //Assign user input to choice variable using the readInteger function
            choice = input.readInteger("Choose a song to play or select 0 to go back:",
                    "Choose a valid genres or enter 0 to go back", 0, genresSongsOptionslist.size());
            if (choice == 0) {
                mainMenu();
            } else {
                List<String> fileList = genresList.getFilesForSong(genresSongsOptionslist.get(choice - 1));

                PlaySong play = new PlaySong();
                boolean playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                while (!playSuccess) {
                    System.out.println("\u274c Cannot play this song, choose another song");
                    choice = input.readInteger("Choose a song to play:",
                            "\u26A0 Choose a valid song or enter 0 to go back", 0, genresSongsOptionslist.size());
                    if (choice == 0) {
                        mainMenu();
                    } else {
                        fileList = genresList.getFilesForSong(genresSongsOptionslist.get(choice - 1));
                        playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                    }

                }
            }
        } else mainMenu();
    }


    public void searchMenu() {

        Search search1 = new Search();

        List<String> searchedSongslist = search1.searchSongs();

        if (searchedSongslist != null) {
            printMenu(searchedSongslist, "Search for a song:");
        } else mainMenu();

        //UserInput class to verify and get only valid user input
        UserInput input = new UserInput();

        //Assign user input to choice variable using the readInteger function
        int choice = input.readInteger("Choose a song to play or select 0 to go back:",
                "\u26A0 Invalid Entry, choose a song or enter 0 to go back", 0, searchedSongslist.size());
        if (choice == 0) {
            mainMenu();
        } else {
            GetItemsFromData songsList = new GetItemsFromData();
            List<String> fileList = songsList.getFilesForSong(searchedSongslist.get(choice - 1));
            PlaySong play = new PlaySong();
            boolean playSuccess = play.playSong(fileList.get(0), fileList.get(1));
            while (!playSuccess) {
                System.out.println("\u274c Cannot play this song, choose another song");
                choice = input.readInteger("Choose a song to play:",
                        "\u26A0 Choose a valid song or enter 0 to go back", 0, searchedSongslist.size());
                if (choice == 0) {
                    mainMenu();
                } else {
                    fileList = songsList.getFilesForSong(searchedSongslist.get(choice - 1));
                    playSuccess = play.playSong(fileList.get(0), fileList.get(1));
                }

            }

        }


    }

    //function to print menu
    public void printMenu(List<String> options, String menuType) {

        //clear the screen before any menu
        ClearScreen cls = new ClearScreen();
        cls.ClearConsole();

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


}





