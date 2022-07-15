import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GetItemsFromData {

    ReadDataFromTextFile rd = new ReadDataFromTextFile();

    public List<String> getSongs() {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = rd.getData();
        List<String> songsList = new ArrayList<String>();
        for (int i = 0; i < data.size(); i++) {
            String str;
            str = ((data.get(i).get(0)));
            if (!songsList.contains(str))
                songsList.add(str);
        }
        return songsList;
    }

    public List<String> getSongs(String type, String value) {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = rd.getData();
        List<String> songsList = new ArrayList<String>();
        if(type.equalsIgnoreCase("artist")) {
            for (int i = 0; i < data.size(); i++) {
                String str, str1;
                str = ((data.get(i).get(1)));
                str1 = ((data.get(i).get(0)));
                if (str.equalsIgnoreCase(value)) {
                    if (!songsList.contains(str1))
                        songsList.add(str1);
                }
            }
            return songsList;
        } else if (type.equalsIgnoreCase("albums")) {
            for (int i = 0; i < data.size(); i++) {
                String str, str1;
                str = ((data.get(i).get(2)));
                str1 = ((data.get(i).get(0)));
                if (str.equalsIgnoreCase(value)) {
                    if (!songsList.contains(str1))
                        songsList.add(str1);
                }
            }
            return songsList;

        } else if (type.equalsIgnoreCase("genres")) {
            for (int i = 0; i < data.size(); i++) {
                String str, str1;
                str = ((data.get(i).get(3)));
                str1 = ((data.get(i).get(0)));
                if (str.equalsIgnoreCase(value)) {
                    if (!songsList.contains(str1))
                        songsList.add(str1);
                }
            }
            return songsList;
        }

        return null;
    }


    public List<String> getArtist() {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = rd.getData();
        List<String> artistList = new ArrayList<String>();
        for (int i = 0; i < data.size(); i++) {
            String str;
            str = ((data.get(i).get(1)));
            if (!artistList.contains(str))
                artistList.add(str);
        }
        return artistList;
    }

    public List<String> getAlbums()  {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = rd.getData();
        List<String> albumList = new ArrayList<String>();
        for (int i = 0; i < data.size(); i++) {
            String str;
            str = ((data.get(i).get(2)));
            if (!albumList.contains(str))
                albumList.add(str);
        }
        return albumList;

    }

    public List<String> getGenres()  {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        data = rd.getData();
        List<String> genresList = new ArrayList<String>();
        for (int i = 0; i < data.size(); i++) {
            String str;
            str = ((data.get(i).get(3)));
            if (!genresList.contains(str))
                genresList.add(str);
        }
        return genresList;
    }

}
