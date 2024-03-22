package linkedlist;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class LinkedList<T extends Comparable<T>> {
    private ListNode<T> head;

    public LinkedList() {
        this.head = null;
    }
    
    public void insert(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void delete(T data) {
        if (head == null) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        ListNode<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
    
    public void printList() {
        ListNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            ListNode<T> current = head;
            ListNode<T> previous = null;
            while (current.next != null) {
                if (current.data.compareTo(current.next.data) > 0) {
                    ListNode<T> temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    if (previous == null) {
                        head = temp;
                    } else {
                        previous.next = temp;
                    }
                    previous = temp;
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }
}
