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

            try {
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}