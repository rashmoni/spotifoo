import java.awt.*;
import java.io.File;


public class PlaySong {

    // This methods plays song and also displays the image
    public boolean playSong(String mp3, String png) {

        boolean playsuccess = false;
        final String ERROR_MSG = "Not Supported";
        final String USERDIR = "user.dir";
        //Generate file paths
        String pathToMp3 = System.getProperty(USERDIR) + "/assets/songs/" + mp3;
        String pathToPng = System.getProperty(USERDIR) + "/assets/albums/" + png;

        //Default image file path
        String pathToDefaultimage = System.getProperty(USERDIR) + "/assets/no-picture.png";

        try {
            //constructor of file class having file as argument
            File song = new File(pathToMp3);

            //To get the file extention (.mp3)
            String fileExt = getFileExtension(song);

            File image = new File(pathToPng);
            File defaultImage = new File(pathToDefaultimage);

            if (song.exists() && fileExt.equalsIgnoreCase(".mp3")) {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(song);
                System.out.println("\u25B6 playing song..");
                playsuccess = true;
                if (image.exists()) {
                    desktop.open(image);
                } else
                    desktop.open(defaultImage);
            }
        } catch (Exception e) {
        }
        return playsuccess;
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf);
    }
}