package unit11.concurrency;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable {
    private static final Random RNG = new Random();
    private final LinkedList<String> queue;
    private final int id;

    public Producer(LinkedList<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        int count = 0;
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            int number = RNG.nextInt(5) + 1;
            for(int i = 0; i < number; i++) {
                synchronized(queue) {
                    queue.add(id + " message #" + count++);
                    queue.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();

        for(int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer(queue, i);
            new Thread(consumer).start();
        }

        for(int i = 0; i < 2; i++) {
            Producer producer = new Producer(queue, i);
            new Thread(producer).start();
        }
    }
}
