package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Diego Casignia
 */
public class Concurrent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\tConcurrent");
        Thread thread1 = new Thread(new MyRunnable("Thread 1"));
        Thread thread2 = new Thread(new MyRunnable("Thread 2"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nConcurrent synchronization");
        Lock lock = new ReentrantLock();

        Thread lockThread1 = new Thread(new MyLockRunnable("Lock Thread 1", lock));
        Thread lockThread2 = new Thread(new MyLockRunnable("Lock Thread 2", lock));
        lockThread1.start();
        lockThread2.start();
    }

}
