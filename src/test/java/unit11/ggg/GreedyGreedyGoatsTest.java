package unit11.ggg; // Ensure the tests are in the same package

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GreedyGreedyGoatsTest {
    @Test
    public void testGoatEatTurnip() {
        Trough trough = new Trough(1);
        Goat goat = new Goat(Color.CYAN, trough);

        // Drop a turnip into the trough
        trough.drop();

        // Directly call run to simulate goat eating
        goat.run();

        // Verify the trough is empty after eating
        assertTrue(trough.isEmpty());

        // Verify the goat has consumed 1 turnip
        assertEquals(1, goat.getTurnipsEaten());
    }

    @Test
    public void testGoatWaitForTurnips() throws InterruptedException {
        Trough trough = new Trough(1);
        Goat goat = new Goat(Color.YELLOW, trough);

        // Create a separate thread to drop turnips asynchronously
        Thread dropperThread = new Thread(() -> {
            try {
                Thread.sleep(100); // Simulate time delay
                trough.drop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the dropper thread and wait for it to complete
        dropperThread.start();
        dropperThread.join();

        // Directly call run to simulate goat waiting and eating
        goat.run();

        // Verify the trough is empty after eating
        assertTrue(trough.isEmpty());

        // Verify the goat has consumed 1 turnip
        assertEquals(1, goat.getTurnipsEaten());
    }

    @Test
    public void testTroughDrop() {
        Trough trough = new Trough(3);

        // Drop 2 turnips into the trough
        trough.drop();
        trough.drop();

        // Verify the current turnips in the trough
        assertEquals(2, trough.getTurnipsSoFar());
    }
}
