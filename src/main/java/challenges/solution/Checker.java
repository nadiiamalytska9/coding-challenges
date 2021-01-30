package challenges.solution;

import java.util.Comparator;

class Player {
    String name;
    int score;

    @Override
    public String toString() {
        return "[" + name + ", " + score + ']';
    }

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score < b.score) return 1;
        else if (a.score > b.score) return -1;
        else return a.name.compareTo(b.name);
    }
}