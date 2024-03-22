package stack;

/**
 *
 * @author Diego Casignia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        boolean finish = false;
        int data;
        do{
            System.out.println("""
                             STACK
                             1. Push
                             2. Pop
                             3. Peek
                             4. Merge Sort
                             5. Exit""");
            switch (Validation.enterInteger("Option: ")){
                case 1:
                    data = Validation.enterInteger("Enter a integer: ");
                    stack.push(data);
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.peek());
                    break;
                case 4:
                    stack.mergeSort();
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
