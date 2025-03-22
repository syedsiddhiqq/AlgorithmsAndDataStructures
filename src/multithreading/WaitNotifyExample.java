package multithreading;

public class WaitNotifyExample {

    private static class SharedResource {
        private int data;
        private boolean hasData = false;

        // Producer method
        public synchronized void produce(int value) throws InterruptedException {
            while (hasData) {
                wait(); // Wait if data is already available
            }
            data = value;
            hasData = true;
            System.out.println("Produced: " + value);
            notify(); // Notify the consumer
        }

        // Consumer method
        public synchronized void consume() throws InterruptedException {
            while (!hasData) {
                wait(); // Wait until data is available
            }
            System.out.println("Consumed: " + data);
            hasData = false;
            notify(); // Notify the producer
        }
    }

    private static class Producer extends Thread {
        SharedResource resource;
        Producer(SharedResource resource) { this.resource = resource; }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    resource.produce(i);
                    Thread.sleep(500); // Simulating delay
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    private static class Consumer extends Thread {
        SharedResource resource;
        Consumer(SharedResource resource) { this.resource = resource; }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    resource.consume();
                    Thread.sleep(1000); // Simulating delay
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        new Producer(resource).start();
        new Consumer(resource).start();
    }
}
