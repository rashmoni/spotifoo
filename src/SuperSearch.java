import java.util.ArrayList;
import java.util.List;

public class SuperSearch {


    public List<String> supSearch() {

        DisplayController ds = new DisplayController();
        ds.clearConsole();

        UserInput input = new UserInput();

        GetItemsFromData data = new GetItemsFromData();

        List<String> songs = data.getSongs();
        List<String> albums = data.getAlbums();
        List<String> genres = data.getGenres();
        List<String> artists = data.getArtist();

        List<String> searchSongsList = new ArrayList<>();
        List<String> searchAlbumsList = new ArrayList<>();
        List<String> searchGenresList = new ArrayList<>();
        List<String> searchArtistList = new ArrayList<>();

        List<String> searchItemList = new ArrayList<>();
        while (searchItemList.isEmpty()) {
            String searchText = input.readText("Enter something you want to search:");

            for (int i = 1; i < songs.size(); i++) {
                if (songs.get(i).toLowerCase().contains(searchText.toLowerCase())) {
                    searchSongsList.add(songs.get(i));
                }
            }
            if (!searchSongsList.isEmpty()) {
                searchSongsList.add(0, "Songs");
            }


            for (int i = 1; i < albums.size(); i++) {
                if (albums.get(i).toLowerCase().contains(searchText.toLowerCase())) {
                    searchAlbumsList.add(albums.get(i));
                }
            }
            if (!searchAlbumsList.isEmpty()) {
                searchAlbumsList.add(0, "Albums");
            }

            for (int i = 1; i < genres.size(); i++) {
                if (genres.get(i).toLowerCase().contains(searchText.toLowerCase())) {
                    searchGenresList.add(genres.get(i));
                }
            }
            if (!searchGenresList.isEmpty()) {
                searchGenresList.add(0, "Genres");
            }

            for (int i = 1; i < artists.size(); i++) {
                if (artists.get(i).toLowerCase().contains(searchText.toLowerCase())) {
                    searchArtistList.add(artists.get(i));
                }
            }
            if (!searchArtistList.isEmpty()) {
                searchArtistList.add(0, "Artists");
            }

            searchItemList.addAll(searchSongsList);
            searchItemList.addAll(searchAlbumsList);
            searchItemList.addAll(searchGenresList);
            searchItemList.addAll(searchArtistList);

        }
        return searchItemList;
    }
}