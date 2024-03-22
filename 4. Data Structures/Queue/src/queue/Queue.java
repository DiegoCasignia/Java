package queue;

import java.util.EmptyStackException;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class Queue<T> {
    private QueueNode<T> front;
    private QueueNode<T> rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T data) {
        QueueNode<T> newNode = new QueueNode<>(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return front.data;
    }
}
