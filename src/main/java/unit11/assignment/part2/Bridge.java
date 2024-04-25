package unit11.assignment.part2;

public class Bridge {
    public boolean occupied = false;

    public synchronized void enterBridge(String name) throws InterruptedException {
        Thread.sleep(500);
        while(occupied) {
            wait();
        }
        occupied = true;
        System.out.println(name + " has entered the bridge.");
    }

    public synchronized void leaveBridge(String name) {
        occupied = false;
        System.out.println(name + " has left the bridge.");
        notify();
    }
}
