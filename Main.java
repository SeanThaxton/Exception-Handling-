// Imports
import java.util.Scanner;

//Main Program
class Main{
    public static void main(String[] args) {

        //The inital setup for the program
        boolean start = true;
        Scanner theScan = new Scanner(System.in);

        //continuously asking user for a correct date
        while (start) {
            System.out.println("Give me a date in the format of MM/DD/YYYY");
            String user = theScan.nextLine();

            //The exception handling
            try {
                String[] tokenizeUser = user.split("/");
                if(tokenizeUser.length != 3){
                    throw new ArrayIndexOutOfBoundsException("The date must have three parts: MM, DD, and YYYY.");
                }
                
            } catch (Exception e) {
                // TODO: handle exception
            }
            

        }

    }

    private static void validDate(int month, int day, int year){


    }
}