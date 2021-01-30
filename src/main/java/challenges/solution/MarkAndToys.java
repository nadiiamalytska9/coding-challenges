package challenges.solution;

import java.util.Arrays;

public class MarkAndToys {
    static int maximumToys(int[] prices, int k) {
        int count = 0;
        Arrays.sort(prices);
        for (int i = 0; i < prices.length; i++) {
            k -= prices[i];
            if (k <= 0) break;
            count++;
        }
        return count;
    }
}
