package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionExample {

    public static class BankAccount {
        private int balance = 1000;

        void withdraw(int amount) {
            if (balance >= amount) {  // Thread 1 & Thread 2 check balance here
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;  // Both threads modify balance at the same time!
                System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " Not enough balance!");
            }
        }

        private final Lock lock = new ReentrantLock();

        void withdrawUsingReentrantLock(int amount) {
            lock.lock();  // 🔒 Acquire lock
            try {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                if (balance >= amount) {
                    balance -= amount;
                }
                System.out.println(Thread.currentThread().getName() + " new balance: " + balance);
            } finally {
                lock.unlock();  // 🔓 Release lock
            }
        }

    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Two threads trying to withdraw money at the same time
        Thread t1 = new Thread(() -> account.withdrawUsingReentrantLock(800), "Thread-1");
        Thread t2 = new Thread(() -> account.withdrawUsingReentrantLock(800), "Thread-2");

        t1.start();
        t2.start();
    }
}

