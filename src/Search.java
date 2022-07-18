import java.util.ArrayList;
import java.util.List;

public class Search {

    public static final String RED = "\033[0;31m";
    public static final String CROSS = "\u274c";
    public static final String ex = "\u26A0";

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\u001B[33m";


    public List<String> searchSongs() {
        ClearScreen cls = new ClearScreen();
        cls.ClearConsole();
        UserInput input = new UserInput();

        // All Songs list
        List<String> allSongList;
        GetItemsFromData allSongs = new GetItemsFromData();
        allSongList = allSongs.getSongs();

        // Searched son list based on search text
        List<String> searchedSongList = new ArrayList<>();

        while (searchedSongList.size() == 0) {
            String searchText = input.readText("Enter song name you want to search:");

            for (String element : allSongList) {
                if (element.toLowerCase().contains(searchText.toLowerCase())) {
                    searchedSongList.add(element);
                }
            }

            if (searchedSongList.size() == 0)  {
                System.out.println("\u26A0"+" No matching songs found, please try again");
            }
        }
        return searchedSongList;

    }
}
