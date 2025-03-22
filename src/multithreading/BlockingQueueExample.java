package multithreading;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class BlockingQueueExample {

    private static class ProducerBQ extends Thread {
        private BlockingQueue<Integer> queue;
        ProducerBQ(BlockingQueue<Integer> queue) { this.queue = queue; }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    private static class ConsumerBQ extends Thread {
        private BlockingQueue<Integer> queue;
        ConsumerBQ(BlockingQueue<Integer> queue) { this.queue = queue; }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    int value = queue.take();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1000);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        new ProducerBQ(queue).start();
        new ConsumerBQ(queue).start();
    }
}
