package doublylinkedlist;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    private ListNode<T> head;
    private ListNode<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public void insertAtEnd(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void insertAtBeginning(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void delete(T data) {
        ListNode<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }
    
    public void printListForward() {
        ListNode<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void printListBackward() {
        ListNode<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
    
    public void selectionSort() {
        if (head == null || head.next == null) {
            return;
        }
        ListNode<T> current = head;
        while (current != null) {
            ListNode<T> minNode = current;
            ListNode<T> temp = current.next;
            while (temp != null) {
                if (temp.data.compareTo(minNode.data) < 0) {
                    minNode = temp;
                }
                temp = temp.next;
            }
            if (minNode != current) {
                T tempVal = current.data;
                current.data = minNode.data;
                minNode.data = tempVal;
            }
            current = current.next;
        }
    }

}
