import javax.imageio.IIOException;
import java.awt.*;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class PlaySong {
    public void playSong(String songName, String albumName) {
        // songName = "andy-you-are-a-star.mp3";
        songName = songName.toLowerCase().replace(" ", "-");
        albumName = albumName.toLowerCase().replace(" ", "-");
        String pathToMp3 = System.getProperty("user.dir") + "/assets/songs/" + songName + ".mp3";
        String pathToPng = System.getProperty("user.dir") + "/assets/albums/" + albumName + ".png";
        String pathToDefaultimage = System.getProperty("user.dir") + "/assets/no-picture.png";
        try {
            //constructor of file class having file as argument
            File song = new File(pathToMp3);
            File image = new File(pathToPng);
            File defaultImage = new File(pathToDefaultimage);
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (song.exists()) {
                try {//checks file exists or not
                    desktop.open(song);
                    System.out.println("playing song " + songName);
                    if (image.exists()) {
                        desktop.open(image);
                    } else
                        desktop.open(defaultImage);
                } catch (UnsupportedOperationException e) {
                    System.out.println("\u274c Cannot play this song");
                }
            }
            else {
                System.out.println("\u274c Cannot play this song");
            }
            //opens the specified file
        } catch (Exception e) {
            System.out.println("\u274c Cannot play this song");
            e.printStackTrace();

        }
    }
}