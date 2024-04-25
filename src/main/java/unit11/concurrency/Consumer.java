package unit11.concurrency;

import java.util.LinkedList;

public class Consumer implements Runnable {
    private final LinkedList<String> queue;
    private final int id;

    public Consumer(LinkedList<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            String job = null;
            synchronized(queue) {
                while(queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {}
                }
                job = queue.remove(0);
            }
            System.out.println(id + ": " + job);
        }
    }
    
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        Consumer consumer1 = new Consumer(queue, 0);
        new Thread(consumer1).start();
        
        Consumer consumer2 = new Consumer(queue, 1);
        new Thread(consumer2).start();
    }
}
