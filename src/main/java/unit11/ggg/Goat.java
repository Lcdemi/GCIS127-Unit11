package unit11.ggg;

public class Goat implements Runnable {
	private Color color;
	private Trough trough;
	private int turnipsEaten;
	
    public Goat(Color color, Trough trough) {
        this.color = color;
        this.trough = trough;
    }

    @Override
    public void run() {
        while(true) {
            if(keepEating()) {
            tryToEat();
            } else {
                try {
                    waitForTurnips();
                } catch (InterruptedException e) {}
            }
            synchronized(trough) {
                if(trough.atLimit() && trough.isEmpty()) {
                    break;
                }
            }
        }
    }

    public int getTurnipsEaten() {
        return turnipsEaten;
    }

    public String toString() {
        return "The " + color + " Goat";
    }

    protected boolean keepEating() {
        synchronized(trough) {
            if(!trough.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    protected void waitForTurnips() throws InterruptedException {
        synchronized(trough) {
            if(trough.isEmpty() && !trough.atLimit()) {
                System.out.println(this.toString() + " is waiting for more turnips.");
                trough.wait();
            }
        }
    }
    
    protected void tryToEat() {
        synchronized(trough) {
            if(trough.eat()) {
                System.out.println(this.toString() + " has eaten a turnip!");
                turnipsEaten++;
                //System.out.println(turnipsEaten); test code
            }
        }
    }
} 
    

