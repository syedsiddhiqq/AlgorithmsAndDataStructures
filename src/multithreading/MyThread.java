package multithreading;

public class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread is running :: " + i + " " + Thread.currentThread());
            try {
                Thread.sleep(500);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

        MyThread myThread3 = new MyThread();
        myThread3.start();

        MyThread myThread4 = new MyThread();
        myThread4.start();

        MyThread myThread5 = new MyThread();
        myThread5.start();

        MyThread myThread6 = new MyThread();
        myThread6.start();

        MyThread myThread7 = new MyThread();
        myThread7.start();

        MyThread myThread8 = new MyThread();
        myThread8.start();

        MyThread myThread9 = new MyThread();
        myThread9.start();

        MyThread myThread10 = new MyThread();
        myThread10.start();

        MyThread myThread11 = new MyThread();
        myThread11.start();

        MyThread myThread12 = new MyThread();
        myThread12.start();

        MyThread myThread13 = new MyThread();
        myThread13.start();

        MyThread myThread14 = new MyThread();
        myThread14.start();

        MyThread myThread15 = new MyThread();
        myThread15.start();

        System.out.println("test " + Thread.currentThread());
    }
}
