package multithreading;

public class DeadlockExample {
    static final Object RESOURCE_A = new Object();
    static final Object RESOURCE_B = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (RESOURCE_A) {
                System.out.println("Thread 1: Locked Resource A");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (RESOURCE_B) {
                    System.out.println("Thread 1: Locked Resource B");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (RESOURCE_B) {
                System.out.println("Thread 2: Locked Resource B");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (RESOURCE_A) {
                    System.out.println("Thread 2: Locked Resource A");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
