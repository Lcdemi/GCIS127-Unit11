package unit11.concurrency;

public class CounterThread extends Thread {
    private final String name;
    
    public CounterThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i < 101; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterThread counter = new CounterThread("Counter");
        counter.start();

        int count = 0;
        while(counter.isAlive()) {
            count++;
            Thread.sleep(50);
        }
        System.out.println("called isAlive " + count + " times.");

        for(char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        //counter.start(); dead code
    }
}
