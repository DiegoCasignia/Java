package concurrent;

import java.util.concurrent.locks.Lock;

/**
 *
 * @author Diego Casignia
 */
public class MyLockRunnable implements Runnable {
    private String name;
    private Lock lock;

    public MyLockRunnable(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("Running " + name + " with Lock");
            for (int i = 0; i < 5; i++) {
                System.out.println("Iteration " + i + " in " + name);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
