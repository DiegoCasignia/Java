package circularlinkedlist;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class CircularLinkedList<T extends Comparable<T>> {
    private ListNode<T> head;

    public CircularLinkedList() {
        this.head = null;
    }

    // Método para insertar un nuevo nodo al final de la lista circular
    public void insert(T val) {
        ListNode<T> newNode = new ListNode<>(val);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Hacer que el nuevo nodo apunte a sí mismo para formar la lista circular
        } else {
            ListNode<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Hacer que el nuevo nodo apunte al inicio de la lista para formar la lista circular
        }
    }

    // Método para eliminar un dato específico de la lista circular
    public void delete(T val) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        ListNode<T> current = head;
        ListNode<T> prev = null;
        do {
            if (current.val.equals(val)) {
                if (current == head) {
                    while (current.next != head) {
                        current = current.next;
                    }
                    head = head.next;
                    current.next = head;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("The value does not exist");
    }

    // Método para imprimir la lista circular
    public void printList() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        ListNode<T> current = head;
        do {
            System.out.print(current.val + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    
    public void insertionSort() {
        if (head == null || head.next == head) {
            return;
        }
        ListNode<T> sorted = null;
        ListNode<T> current = head;
        do {
            ListNode<T> nextNode = current.next;
            sorted = sortedInsert(sorted, current);
            current = nextNode;
        } while (current != head);

        head = sorted;
    }

    private ListNode<T> sortedInsert(ListNode<T> sorted, ListNode<T> newNode) {
        if (sorted == null) {
            newNode.next = newNode;
            return newNode;
        }

        ListNode<T> current = sorted;
        ListNode<T> prev = null;
        do {
            if (current.val.compareTo(newNode.val) > 0) {
                newNode.next = current;
                if (prev != null) {
                    prev.next = newNode;
                } else {
                    ListNode<T> last = getLastNode(sorted);
                    last.next = newNode;
                }
                return newNode;
            }
            prev = current;
            current = current.next;
        } while (current != sorted);

        prev.next = newNode;
        newNode.next = sorted;
        return sorted;
    }
    
    private ListNode<T> getLastNode(ListNode<T> head) {
        ListNode<T> current = head;
        while (current.next != head) {
            current = current.next;
        }
        return current;
    }
}
