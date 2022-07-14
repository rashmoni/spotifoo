import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromTextFile {


    public String[] getSongs() throws IOException {


        List<String> sg = new ArrayList<String>();

        // Using FileReader/ BufferReader
        FileReader fr = new FileReader("/Users/rashmonidey/Desktop/spotifoo/assets/data.txt");

        BufferedReader br = new BufferedReader(fr);
        String str;

        while ((str=br.readLine()) !=null){
            String[] sg1 = new String[1];
            sg1 = str.split(",");
            sg.add(sg1[0]);
        }
        br.close();
        String[] songs = new String [sg.size()];
        sg.toArray(songs);

        return songs;
    }
}
