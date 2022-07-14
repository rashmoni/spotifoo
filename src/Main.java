import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Welcome message
        System.out.println("Welcome to Spotifoo music player!");
        System.out.println();

        //MenuController menu = new MenuController();
        //menu.mainMenu();
        ReadDataFromTextFile rf= new ReadDataFromTextFile();
        String[] songs = rf.getSongs();

        for(int i=0;i< songs.length;i++){
            System.out.println(songs[i]);
        }
    }
}
