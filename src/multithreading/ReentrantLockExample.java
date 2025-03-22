package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static class SharedResource {
        private final Lock lock = new ReentrantLock(); // Creating the lock
        private int counter = 0;

        void increment() {
            lock.lock(); // Acquire lock
            try {
                counter++;
                System.out.println(Thread.currentThread().getName() + " incremented: " + counter);
            } finally {
                lock.unlock(); // Release lock
            }
        }

        void accessResource() {
            if (lock.tryLock()) { // Tries to acquire the lock
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired lock.");
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock(); // Always unlock
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock.");
            }
        }

        void accessResourceInterupt() {
            try {
                lock.lockInterruptibly(); // Acquire lock but allow interruption
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired lock.");
                    Thread.sleep(5000);
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for lock.");
            }
        }
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(resource::accessResourceInterupt, "Thread-1");
        Thread t2 = new Thread(resource::accessResourceInterupt, "Thread-2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
            t2.interrupt(); // Interrupt t2 while it's waiting for the lock
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}