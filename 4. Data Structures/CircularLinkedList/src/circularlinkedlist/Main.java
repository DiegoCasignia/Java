package circularlinkedlist;

/**
 *
 * @author Diego Casignia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        boolean finish = false;
        int data;
        do{
            System.out.println("""
                             CIRCULAR LINKED LIST:
                             1. Insert
                             2. Delete
                             3. Print
                             4. Insertion Sort
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
                    list.insertionSort();
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
