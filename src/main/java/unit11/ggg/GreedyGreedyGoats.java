package unit11.ggg;

import java.util.LinkedList;
import java.util.List;

public class GreedyGreedyGoats {
    public static void main(String[] args) throws InterruptedException {
        //Creating Trough and TurnipDropper
        Trough trough = new Trough(250);
        TurnipDropper dropper = new TurnipDropper(trough);
        Thread gameThread = new Thread(dropper);
        gameThread.start();

        //Creating Goats and List of Goats
        List<Goat> goats = new LinkedList<>();
        Goat cyan = new Goat(Color.CYAN, trough);
        Goat yellow = new Goat(Color.YELLOW, trough); 
        Goat green = new Goat(Color.GREEN, trough); 
        Goat orange = new Goat(Color.ORANGE, trough);
        goats.add(cyan);
        goats.add(yellow);
        goats.add(green);
        goats.add(orange);

        //Starting Goat Threads
        Thread cyanThread = new Thread(cyan);
        Thread yellowThread = new Thread(yellow);
        Thread greenThread = new Thread(green);
        Thread orangeThread = new Thread(orange);
        cyanThread.start();
        yellowThread.start();
        greenThread.start();
        orangeThread.start();

        // Wait for all threads to finish
        gameThread.join();
        cyanThread.join();
        yellowThread.join();
        greenThread.join();
        orangeThread.join();

        System.out.println("The game is over! A total of " + trough.getTurnipsSoFar() + " turnips were dropped into the trough!");
        //Sorts by turnipsEaten from greatest to least
        goats.sort(new ScoreComparator());
        for(Goat goat : goats) {
            System.out.println(goat.toString() + " ate " + goat.getTurnipsEaten() + " turnips!");
        }
        System.out.println("Together, the goats ate " + (cyan.getTurnipsEaten() + yellow.getTurnipsEaten() + green.getTurnipsEaten() + orange.getTurnipsEaten()) + " turnips!");
        System.out.println("The winner is " + goats.get(0).toString());
    }

    // The game is over! A total of 250 turnips were dropped into the trough!
    // The ORANGE goat ate 99 turnips!
    // The CYAN goat ate 92 turnips!
    // The YELLOW goat ate 59 turnips!
    // The GREEN goat ate 0 turnips!
    // Together, the goats ate 250 turnips!

}
