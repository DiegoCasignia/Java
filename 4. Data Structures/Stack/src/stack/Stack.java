package stack;

import java.util.EmptyStackException;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class Stack<T extends Comparable<T>> {
    private StackNode<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        StackNode<T> newNode = new StackNode<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void mergeSort() {
        top = mergeSortRec(top);
    }

    private StackNode<T> mergeSortRec(StackNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        StackNode<T> mid = getMiddle(head);
        StackNode<T> nextOfMid = mid.next;
        mid.next = null;

        StackNode<T> left = mergeSortRec(head);
        StackNode<T> right = mergeSortRec(nextOfMid);

        return merge(left, right);
    }

    private StackNode<T> merge(StackNode<T> left, StackNode<T> right) {
        StackNode<T> result = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data.compareTo(right.data) <= 0) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private StackNode<T> getMiddle(StackNode<T> head) {
        if (head == null) {
            return head;
        }

        StackNode<T> slow = head;
        StackNode<T> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
