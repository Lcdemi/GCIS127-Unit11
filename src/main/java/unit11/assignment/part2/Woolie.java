package unit11.assignment.part2;

public class Woolie implements Runnable {
    private String name;
    private int speed;
    private String startCity;
    private String endCity;
    private Bridge bridge;

    public Woolie(String name, int speed, String startCity, String endCity, Bridge bridge) {
        this.name = name;
        this.speed = speed;
        this.startCity = startCity;
        this.endCity = endCity;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        System.out.println(name + " has arrived at the bridge at " + startCity + ".");
        try {
            bridge.enterBridge(name);
        } catch (InterruptedException e) {}
        System.out.println(name + " is starting to cross");
        for(int i = 0; i < speed; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("\t" + name + ": " + (i+1) + " seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " arrives at " + endCity);
        bridge.leaveBridge(name);
    }

    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        Woolie Henry = new Woolie("Henry", 4, "Pittsburgh", "Rochester", bridge);
        Woolie Mary = new Woolie("Mary", 2, "Pittsburgh", "Erie", bridge);
        Woolie John = new Woolie("John", 1, "Pittsburgh", "Harrisburg", bridge);
        Woolie Marcus = new Woolie("Marcus", 3, "Pittsburgh", "Buffalo", bridge);
        Thread thread1 = new Thread(Henry);
        Thread thread2 = new Thread(Mary);
        Thread thread3 = new Thread(John);
        Thread thread4 = new Thread(Marcus);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    
}
