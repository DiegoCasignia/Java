package calculatearea;

import java.util.Scanner;

/**
 *
 * @author Diego Casignia
 */
public class Validation {
    public static boolean isInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static int enterInteger(String text){
        Scanner scanner = new Scanner(System.in);
        String number;
        do{
            System.out.print(text);
            number = scanner.nextLine();
        }while(!isInteger(number));
        return Integer.parseInt(number);
    }
    
    public static boolean isDecimal(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static double enterDecimal(String text){
        Scanner scanner = new Scanner(System.in);
        String number;
        do{
            System.out.print(text);
            number = scanner.nextLine();
        }while(!isDecimal(number));
        return Double.parseDouble(number);
    }
}
