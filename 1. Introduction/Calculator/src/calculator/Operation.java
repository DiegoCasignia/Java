package calculator;

/**
 *
 * @author Diego Casignia
 */
public class Operation {
    public static int addition(){
        int numberA = Validation.enterInteger("Enter number A: ");
        int numberB = Validation.enterInteger("Enter number B: ");
        return numberA + numberB;
    }
    
    public static int substraction(){
        int numberA = Validation.enterInteger("Enter number A: ");
        int numberB = Validation.enterInteger("Enter number B: ");
        return numberA - numberB;
    }
    
    public static int multiplication(){
        int numberA = Validation.enterInteger("Enter number A: ");
        int numberB = Validation.enterInteger("Enter number B: ");
        return numberA * numberB;
    }
    
    public static float division(){
        int numberA = Validation.enterInteger("Enter number A: ");
        int numberB = Validation.enterInteger("Enter number B: ");
        return numberA / numberB;
    }
}
