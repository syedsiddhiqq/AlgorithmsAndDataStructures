package lld;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {
    private LinkedList<T> inputQueue;
    private int size;

    public BlockingQueue(int size) {
        this.inputQueue = new LinkedList<>();
        this.size = size;
    }

    public synchronized T addElement(T item) {
        if (this.size <= this.inputQueue.size()) {
            this.inputQueue.addLast(item);
        } else {
            System.out.println("Blocking Queue size has reached its limit.");
        }
        return item;
    }

    public synchronized T removeElement(T item) {
        if (this.size == 0) {
            System.out.println("No elements present in the queue.");
            return item;
        }
        this.inputQueue.remove(item);
        return item;
    }

    public void increaseQueueSize(int size){
        this.size += size;
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> integerBlockingQueue = new BlockingQueue<Integer>(5);

    }
}
