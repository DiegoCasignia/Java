package queue;

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
}
