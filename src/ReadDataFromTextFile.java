import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadDataFromTextFile {


    private static Scanner file;
    static int rows;

    public List getData(String data) throws FileNotFoundException {

        String type = data;

        //sigle dimension array
        List<String> list = new ArrayList<String>();

        //2d  array list for reading from file
        ArrayList<ArrayList<String>> biD = new ArrayList<ArrayList<String>>();

        file = new Scanner(new File("/Users/rashmonidey/Desktop/spotifoo/assets/data.txt"));

        while (file.hasNextLine()) {
            ArrayList<String> line = new ArrayList<String>();
            final String nextLine = file.nextLine();
            final String[] items = nextLine.split(",");

            for (int i = 0; i < items.length; i++) {
                line.add(items[i]);
            }
            biD.add(line);
            rows++;
            Arrays.fill(items, null); // to clear out the 'items' array
        }


        if (type.equalsIgnoreCase("songs")) {
            List<String> songsList = new ArrayList<String>();
            for (int i = 0; i < biD.size(); i++) {
                String str;
                str = ((biD.get(i).get(0)));
                if (!songsList.contains(str))
                    songsList.add(str);
            }
            return songsList;
        } else if (type.equalsIgnoreCase("artist")) {
            List<String> artistList = new ArrayList<String>();
            for (int i = 0; i < biD.size(); i++) {
                String str;
                str = ((biD.get(i).get(1)));
                if (!artistList.contains(str))
                    artistList.add(str);
            }
            return artistList;

        } else if (type.equalsIgnoreCase("album")) {
            List<String> albumList = new ArrayList<String>();
            for (int i = 0; i < biD.size(); i++) {
                String str;
                str = ((biD.get(i).get(2)));
                if (!albumList.contains(str))
                    albumList.add(str);
            }
            return albumList;

        } else if (type.equalsIgnoreCase("genres")) {
            List<String> genresList = new ArrayList<String>();
            for (int i = 0; i < biD.size(); i++) {
                String str;
                str = ((biD.get(i).get(3)));
                if (!genresList.contains(str))
                    genresList.add(str);
            }
            return genresList;

        }
        return null;
    }
}

