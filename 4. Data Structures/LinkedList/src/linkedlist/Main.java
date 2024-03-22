package linkedlist;

/**
 *
 * @author Diego Casignia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        boolean finish = false;
        int data;
        do{
            System.out.println("""
                             LINKED LIST:
                             1. Insert
                             2. Delete
                             3. Print
                             4. Bubble Sort
                             5. Exit""");
            switch (Validation.enterInteger("Option: ")){
                case 1:
                    data = Validation.enterInteger("Enter a integer: ");
                    list.insert(data);
                    break;
                case 2:
                    data = Validation.enterInteger("Enter a integer: ");
                    list.delete(data);
                    break;
                case 3:
                    list.printList();
                    break;
                case 4:
                    list.bubbleSort();
                    list.printList();
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
