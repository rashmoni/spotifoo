import java.awt.*;
import java.io.File;

public class PlaySong {
        public void playSong(String songName) {
            // songName = "andy-you-are-a-star.mp3";
            String pathToMp3 = "/Users/rashmonidey/Desktop/spotifoo/assets/songs/"+songName+".mp3";
            System.out.println(pathToMp3);
            try {
                //constructor of file class having file as argument
                File file = new File(pathToMp3);
                if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
                {
                    System.out.println("not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if (file.exists())         //checks file exists or not
                    desktop.open(file);              //opens the specified file
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }