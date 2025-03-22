package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteTableFutureLearning {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread() + "This runs asyc using void cf 1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        CompletableFuture<Void> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + "This runs asyc using void cf 2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Thread.currentThread() + " Sleeping for 2 seconds";
        }).thenApply(result -> {
            System.out.println(result);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Thread.currentThread() + " Sleeping for 3 seconds";
        }).thenAccept(result -> {
            System.out.println(result);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(Thread.currentThread() + " Main thread completed...");
//        cf1.get();
//        cf2.get();

        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread() + "This runs asyc using void cf 3");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        cf3.get();
    }
}
