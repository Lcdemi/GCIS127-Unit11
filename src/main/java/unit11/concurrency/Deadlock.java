package unit11.concurrency;

public class Deadlock implements Runnable {
    private final Object lock1;
    private final Object lock2;

    public Deadlock(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        System.out.println("trying to obtain " + lock1);
        synchronized(lock1) {
            System.out.println("got " + lock1 + ", trying to obtain " + lock2);
            synchronized(lock2) {
                System.out.println("Got both locks!");
            }
        }
    }

    public static void main(String[] args) {
        String lockA = "Lock A";
        String lockB = "Lock B";
        Deadlock deadlock1 = new Deadlock(lockA, lockB);
        Deadlock deadlock2 = new Deadlock(lockB, lockA);

        Thread thread1 = new Thread(deadlock1);
        thread1.start();
        
        Thread thread2 = new Thread(deadlock2);
        thread2.start();
    }
    
}
