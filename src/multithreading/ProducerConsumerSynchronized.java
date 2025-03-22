package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerSynchronized {

    private static Queue<Integer> q = new LinkedList<>();

    private static class Producer extends Thread{
        private static void produce() {
            for (int i = 0; i < 5; i++) {
                int finalI = i;
                new Thread(() -> {
                    add(finalI);
                });
            }
        }
    }

    private static synchronized void add(int i) {
        try {
            q.add(i);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized void remove(int i) {
        try {
            System.out.println(q.poll());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    private static void consumer() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                add(finalI);
            });
        }
    }

    public static void main(String[] args) {

    }
}
