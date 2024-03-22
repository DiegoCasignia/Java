package queue;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class QueueNode<T> {
    T data;
    QueueNode<T> next;

    public QueueNode(T data) {
        this.data = data;
    }
}
