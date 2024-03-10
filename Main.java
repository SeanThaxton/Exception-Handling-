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
                
                int month = Integer.parseInt(tokenizeUser[0]);
                int day = Integer.parseInt(tokenizeUser[1]);
                int year = Integer.parseInt(tokenizeUser[2]);

                validateDay(month, day, year);
                if(month < 1 || month > 12){
                    throw new MonthException("The month enter is not a valid gregorian calendar month. Try again.");
                }
                if (year < 1000 || year > 3000) {
                    throw new YearException("Invalid year. Please enter a year between 1000 and 3000.");
                }

                String monthName = convertMonthToName(month); // Implement this method to convert numeric month to name.
                System.out.println("Formatted date: " + monthName + " " + day + ", " + year);


                start = false;
            } catch (NumberFormatException e) {
                System.out.println("The date must be in numbers.");
            
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            } catch (DayException e) {
                System.out.println(e.getMessage());
            } catch (MonthException e) {
                System.out.println(e.getMessage());
            } catch (YearException e) {
                System.out.println(e.getMessage());
            }
        catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
            }
        }
        theScan.close();

    }
    private static void validateDay(int month, int day, int year) throws DayException {
        int daysInMonth = switch (month) {
            case 2 -> (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };

        if (day < 1 || day > daysInMonth) {
            throw new DayException("Invalid day. Please enter a valid day for the given month and year.");
        }
    }

    private static String convertMonthToName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> throw new IllegalArgumentException("Invalid month number.");
        };
    }
}