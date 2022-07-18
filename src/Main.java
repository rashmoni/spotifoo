import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        MenuController application = new MenuController();
        application.mainMenu();
        /*ReadDataFromTextFile rf= new ReadDataFromTextFile();
        String[] songs = rf.getSongs();

        for(int i=0;i< songs.length;i++){
            System.out.println(songs[i]);
        }*/
    }
}
