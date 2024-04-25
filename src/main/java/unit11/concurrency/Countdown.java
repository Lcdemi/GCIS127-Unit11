package unit11.concurrency;

public class Countdown implements Runnable {

    @Override
    public void run() {
        int time = -10;
        while(true) {
            if(time == 0) {
                System.out.println("Liftoff");
            } else if(time > 0) {
                System.out.println("T+" + time);
            } else {
                System.out.println("T" + time);
            }
            time++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        Thread thread = new Thread(countdown);
        thread.start();
    }
    
}
