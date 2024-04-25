package unit11.ggg;

import java.util.Random;

public class TurnipDropper implements Runnable {
	private final Trough trough;
    private static final Random turnipDrop = new Random();
    private static final Random randomSleep = new Random();

	public TurnipDropper(Trough trough) {
		this.trough = trough;
	}

	@Override
	public void run() {
		while(keepDropping()) {
            dropTurnips();
        }
	}

	protected boolean keepDropping() {
        synchronized(trough) {
            if(!trough.atLimit())
                return true;
            return false;
	    }
	}
	protected void dropTurnips() {
        int randomNum = turnipDrop.nextInt(3) + 1;
            for(int i = 0; i < randomNum; i++) {
                synchronized(trough) {
                    trough.drop();
                    trough.notifyAll();
                    try {
                        Thread.sleep(randomSleep.nextInt(250) + 1);
                    } catch (InterruptedException e) {}
                }
            }
            System.out.println("The dropper drops " + randomNum + " turnips into the trough!");
	}
}


