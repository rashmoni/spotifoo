import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadDataFromTextFile {

    private static Scanner file;
    static int rows;

    public ArrayList<ArrayList<String>> getData()  {

        //sigle dimension array
        List<String> list = new ArrayList<String>();

        //2d  array list for reading from file
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();


        String path =System.getProperty("user.dir");

        try {
            file = new Scanner(new File(path+"//assets//data.txt"));
        }catch(FileNotFoundException e){
            System.out.println(e);
        }

        while (file.hasNextLine()) {
            ArrayList<String> line = new ArrayList<String>();
            final String nextLine = file.nextLine();
            final String[] items = nextLine.split(",");

            for (int i = 0; i < items.length; i++) {
                line.add(items[i]);
            }
            data.add(line);
            rows++;
            Arrays.fill(items, null); // to clear out the 'items' array
        }
        return data;

    }


}


