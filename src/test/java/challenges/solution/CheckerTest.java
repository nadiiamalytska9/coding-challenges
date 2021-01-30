package challenges.solution;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckerTest {
    @Test
    public void shouldSortPlayers() {
        Player p1 = new Player("amy", 100);
        Player p2 = new Player("david", 100);
        Player p3 = new Player("heraldo", 50);
        Player p4 = new Player("aakansha", 75);
        Player[] players = {p1, p2, p3, p4};
        Player[] expectedSortedPlayers = {p1, p2, p4, p3};

        Arrays.sort(players, new Checker());

        assertThat("Expected sorted players: [" + expectedSortedPlayers + "]. But received wrong value: [" + players + "]",
                expectedSortedPlayers, is(players));
    }
}
