package calculator;

/**
 *
 * @author Diego Casignia
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean finish = false;
        do {
            System.out.println("""
                             Calculate:
                             1. Addition
                             2. Substraction
                             3. Multiplication
                             4. Division
                             5. Exit""");
           switch (Validation.enterInteger("Option: ")) {
                    case 1:
                        System.out.println("A + B = " + Operation.addition());
                        break;
                    case 2:
                        System.out.println("A - B = " + Operation.substraction());
                        break;
                    case 3:
                        System.out.println("A * B = " + Operation.multiplication());
                        break;
                    case 4:
                        System.out.println("A / B = " + Operation.division());
                        break;
                    case 5:
                        finish = true;
                        break;
                    default:
                        break;
                }
        } while (!finish);
    }
}
