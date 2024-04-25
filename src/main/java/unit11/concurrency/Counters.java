package unit11.concurrency;

public class Counters {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++) {
            RunnableCounter runnable = new RunnableCounter("runnable" + i);
            Thread thread = new Thread(runnable);
            thread.start();
            //thread.join(); //only runs one thread at a time
            threads[i] = thread;
        }
        for(Thread thread : threads) {
            thread.join();
        }
    }
    
}
