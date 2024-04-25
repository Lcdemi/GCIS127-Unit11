package unit11.ggg;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Goat> {
    @Override
    public int compare(Goat g1, Goat g2) {
        return g2.getTurnipsEaten() - g1.getTurnipsEaten();
    }
}
