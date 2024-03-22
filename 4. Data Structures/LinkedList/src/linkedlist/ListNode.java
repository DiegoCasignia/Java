package linkedlist;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class ListNode<T> {
    T data;
    ListNode<T> next;

    ListNode(T val) {
        this.data = val;
        this.next = null;
    }
}
