package queue;

/**
 *
 * @author Diego Casignia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        boolean finish = false;
        int data;
        do{
            System.out.println("""
                             QUEUE
                             1. Enqueue
                             2. Dequeue
                             3. Peek
                             4. Exit""");
            switch (Validation.enterInteger("Option: ")){
                case 1:
                    data = Validation.enterInteger("Enter a integer: ");
                    queue.enqueue(data);
                    break;
                case 2:
                    System.out.println(queue.dequeue());
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                case 4:
                    finish = true;
                    break;
                default:
                    break;
            }
        } while (!finish);
    }

}
