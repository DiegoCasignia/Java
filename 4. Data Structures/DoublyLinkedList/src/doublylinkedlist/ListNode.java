package doublylinkedlist;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class ListNode<T> {
    T data;
    ListNode<T> prev;
    ListNode<T> next;

    ListNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
