import java.awt.*;
import java.io.File;


public class PlaySong {

    // This methods plays song and also displays the image
    public void playSong(String mp3, String png) {

        //Generate file paths
        String pathToMp3 = System.getProperty("user.dir") + "/assets/songs/" + mp3;
        String pathToPng = System.getProperty("user.dir") + "/assets/albums/" + png;

        //Default image file path
        String pathToDefaultimage = System.getProperty("user.dir") + "/assets/no-picture.png";

        try {
            //constructor of file class having file as argument
            File song = new File(pathToMp3);
            File image = new File(pathToPng);
            File defaultImage = new File(pathToDefaultimage);
            if (song.exists()&& mp3.contains(".mp3")) {
            if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
            {
                System.out.println("not supported");
            }
            Desktop desktop = Desktop.getDesktop();

                try {
                    desktop.open(song);
                    System.out.println("\u25B6 playing song..");
                    if (image.exists()) {
                        desktop.open(image);
                    } else
                        desktop.open(defaultImage);
                } catch (UnsupportedOperationException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("\u274c Cannot play this song");
            }
            //opens the specified file
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}