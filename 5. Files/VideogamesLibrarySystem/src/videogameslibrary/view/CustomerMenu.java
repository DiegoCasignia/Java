package videogameslibrary.view;

import videogameslibrary.utils.FileManager;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Diego Casignia
 */
public class CustomerMenu {
    public void showCustomerMenu() throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        FileManager editVideogameData = new FileManager();

        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println("\n\t*** Customer Menu ***\n");
            System.out.println("1. Read videogames");
            System.out.println("2. Exit");
            System.out.print("\n\tOption: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1: 
                    editVideogameData.readVideogameData();
                    break;

                case 2:
                    continueMenu = false;
                    break;
                    
                default:
                    System.out.println("");
            }
        }
    }
}
