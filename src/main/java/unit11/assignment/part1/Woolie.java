package unit11.assignment.part1;

public class Woolie implements Runnable {
    private String name;
    private int speed;
    private String startCity;
    private String endCity;

    public Woolie(String name, int speed, String startCity, String endCity) {
        this.name = name;
        this.speed = speed;
        this.startCity = startCity;
        this.endCity = endCity;
    }

    @Override
    public void run() {
        System.out.println(name + " has arrived at the bridge at " + startCity + ".");
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
    }

    public static void main(String[] args) {
        Woolie Henry = new Woolie("Henry", 4, "Pittsburgh", "Rochester");
        Woolie Mary = new Woolie("Mary", 2, "Pittsburgh", "Erie");
        Woolie John = new Woolie("John", 1, "Pittsburgh", "Harrisburg");
        Woolie Marcus = new Woolie("Marcus", 3, "Pittsburgh", "Buffalo");
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
