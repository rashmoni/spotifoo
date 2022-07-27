import java.util.ArrayList;
import java.util.List;

public class Search {
    public List<String> searchSongs() {
        DisplayController cls = new DisplayController();
        cls.clearConsole();
        UserInput input = new UserInput();

        // All Songs list
        List<String> allSongList;
        GetItemsFromData allSongs = new GetItemsFromData();
        allSongList = allSongs.getSongs();

        // Searched son list based on search text
        List<String> searchedSongList = new ArrayList<>();

        while (searchedSongList.isEmpty()) {
            String searchText = input.readText("Enter song name you want to search:");

            for (String element : allSongList) {
                if (element.toLowerCase().contains(searchText.toLowerCase())) {
                    searchedSongList.add(element);
                }
            }

            if (searchedSongList.isEmpty())  {
                System.out.println("\u26A0"+" No matching songs found, please try again");
            }
        }
        return searchedSongList;

    }
}
