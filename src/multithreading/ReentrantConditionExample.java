package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantConditionExample {

    private static class SharedQueue {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition notEmpty = lock.newCondition();
        private int data = -1;

        void produce(int value) {
            lock.lock();
            try {
                data = value;
                System.out.println("Produced: " + data);
                notEmpty.signal(); // Notify consumer
            } finally {
                lock.unlock();
            }
        }

        void consume() {
            lock.lock();
            try {
                while (data == -1) {
                    System.out.println("Waiting for data.. ");
                    notEmpty.await(); // Wait if no data
                }
                System.out.println("Consumed: " + data);
                data = -1; // Reset data
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                queue.produce(i);
            }
        });

        Thread consumer = new Thread(queue::consume);


        consumer.start();
        producer.start();
    }
}
