import java.util.ArrayList;
import java.util.List;

public class GetItemsFromData {


    //Create object to read data from data.txt
    ReadDataFromTextFile textData = new ReadDataFromTextFile();


    //This method returns list of all the songs
    public List<String> getSongs() {
        ArrayList<ArrayList<String>> data;
        data = textData.getData();
        List<String> songsList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String str = ((data.get(i).get(0)));
            if (!songsList.contains(str))
                songsList.add(str);
        }
        return songsList;
    }

    /* This method returns songs based on type (artists, albums and genres) and the value of
    the type. For example if type is 'artist' and value is 'The Killers',
    then it returns all the songs of the artist - The Killers ) */
    public List<String> getSongs(String type, String value) {
        ArrayList<ArrayList<String>> data;
        data = textData.getData();
        List<String> songsList = new ArrayList<>();
        if (type.equalsIgnoreCase("artist")) {
            for (int i = 0; i < data.size(); i++) {
                String strArtist, strSong;
                strArtist = ((data.get(i).get(1)));
                strSong = ((data.get(i).get(0)));
                if (strArtist.equalsIgnoreCase(value)) {
                    if (!songsList.contains(strSong))
                        songsList.add(strSong);
                }
            }
            return songsList;
        } else if (type.equalsIgnoreCase("albums")) {
            for (int i = 0; i < data.size(); i++) {
                String strAlbum, strSong;
                strAlbum = ((data.get(i).get(2)));
                strSong = ((data.get(i).get(0)));
                if (strAlbum.equalsIgnoreCase(value)) {
                    if (!songsList.contains(strSong))
                        songsList.add(strSong);
                }
            }
            return songsList;

        } else if (type.equalsIgnoreCase("genres")) {
            for (int i = 0; i < data.size(); i++) {
                String strGenres, strSongs;
                strGenres = ((data.get(i).get(3)));
                strSongs = ((data.get(i).get(0)));
                if (strGenres.equalsIgnoreCase(value)) {
                    if (!songsList.contains(strSongs))
                        songsList.add(strSongs);
                }
            }
            return songsList;
        }

        return null;
    }


    //This method returns list of all the artists
    public List<String> getArtist() {
        ArrayList<ArrayList<String>> data;
        data = textData.getData();
        List<String> artistList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String str;
            str = ((data.get(i).get(1)));
            if (!artistList.contains(str))
                artistList.add(str);
        }
        return artistList;
    }


    //This method returns list of all the albums
    public List<String> getAlbums() {
        ArrayList<ArrayList<String>> data;
        data = textData.getData();
        List<String> albumList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String str;
            str = ((data.get(i).get(2)));
            if (!albumList.contains(str))
                albumList.add(str);
        }
        return albumList;

    }
    //This method returns list of all the genres
    public List<String> getGenres() {
        ArrayList<ArrayList<String>> data;
        data = textData.getData();
        List<String> genresList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String str;
            str = ((data.get(i).get(3)));
            if (!genresList.contains(str))
                genresList.add(str);
        }
        return genresList;
    }

    //This method returns mp3 file name and png file name of a particular song
    public List<String> getFilesForSong(String song) {
        ArrayList<ArrayList<String>> data;
        data = textData.getData();
        List<String> fileList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String songString = ((data.get(i).get(0)));
            String mp3 = ((data.get(i).get(4)));
            String png = ((data.get(i).get(5)));
            if (songString.equalsIgnoreCase(song)) {
                if (!fileList.contains(mp3)) {
                    fileList.add(mp3);
                }
                if (!fileList.contains(png)) {
                    fileList.add(png);
                }
            }
        }
        return fileList;
    }

}
