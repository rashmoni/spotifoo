import java.util.Scanner;

public class UserInput {
    private Scanner in;
    UserInput(){
        in = new Scanner(System.in);
    }
    public int readInteger(String promptMsg, String errorMsg, int low, int high){
        int num = 0;
        String strInput;
        boolean valid = false;

        //loop until user input valid value
        while (valid==false){

            //prompt user for input
            System.out.print(promptMsg);

            //User input from keyboard
            strInput = in.nextLine();

            //try block to convert string to int
            try{
                num = Integer.parseInt(strInput);
                if(num>=low && num <= high)
                  valid=true;
                else
                    System.out.println(errorMsg);
            }
            catch(NumberFormatException e){
                System.out.println(errorMsg);
            }
        }
        return num;
    }

}
