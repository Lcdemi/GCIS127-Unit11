package unit11.concurrency;

public class Waiter implements Runnable {
    private final Object lock;

    public Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock) {
            lock.notify();
            try {
                System.out.println("Getting the lock...");
                lock.wait();
                System.out.println("Done Waiting!");
            } catch(InterruptedException e) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread.sleep(100);
        synchronized(lock) {
            for(int i = 0; i < 10; i++) {
                Waiter waiter = new Waiter(lock);
                Thread thread = new Thread(waiter);
                thread.start();
            }
            lock.wait();
            System.out.println("notifying...");
            lock.notifyAll();
        }
    }
    
}
