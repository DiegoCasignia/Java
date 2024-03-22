package circularlinkedlist;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class ListNode<T extends Comparable<T>> {
    T val;
    ListNode<T> next;

    ListNode(T val) {
        this.val = val;
        this.next = null;
    }
    
    public int compareTo(ListNode<T> otherNode) {
        return this.val.compareTo(otherNode.val);
    }
}
