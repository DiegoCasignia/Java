package doublylinkedlist;

/**
 *
 * @author Diego Casignia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        boolean finish = false;
        int data;
        do{
            System.out.println("""
                             DOUBLY LINKED LIST:
                             1. Insert at End
                             2. Insert at Beginning
                             3. Delete
                             4. Print List Forward
                             5. Print List Backward
                             6. Selection Sort
                             7. Exit""");
            switch (Validation.enterInteger("Option: ")){
                case 1:
                    data = Validation.enterInteger("Enter a integer: ");
                    list.insertAtEnd(data);
                    break;
                case 2:
                    data = Validation.enterInteger("Enter a integer: ");
                    list.insertAtBeginning(data);
                    break;
                case 3:
                    data = Validation.enterInteger("Enter a integer: ");
                    list.delete(data);
                    break;
                case 4:
                    list.printListForward();
                    break;
                case 5:
                    list.printListBackward();
                    break;
                case 6:
                    list.selectionSort();
                    list.printListForward();
                    break;
                case 7:
                    finish = true;
                    break;
                default:
                    break;
            }
        } while (!finish);
    }
}
