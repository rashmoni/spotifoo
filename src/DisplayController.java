import java.util.List;

public class DisplayController {
    public void printMenu(List<String> options, String menuType) {

        //clear the screen before any menu
        clearConsole();

        //Welcome message
        System.out.println("Welcome to Spotifoo music player!");
        System.out.println();

        int i = 1;
        if (menuType.equalsIgnoreCase("mainMenu")) {
            System.out.println("Main menu options:");
            for (String option : options) {
                System.out.println("[" + i + "]" + " " + option);
                i++;
            }
        } else {
            System.out.println(menuType);
            for (String option : options) {
                System.out.println("[" + i + "]" + " " + option);
                i++;
            }
            System.out.println("[0] Go back to main menu");
        }
    }

    public void clearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error when clearing the screen " + e);
            Thread.currentThread().interrupt(); // Compliant solution as per Sonarqube
        }
    }
}