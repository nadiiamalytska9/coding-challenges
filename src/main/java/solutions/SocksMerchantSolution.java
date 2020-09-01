package solutions;

import java.util.HashSet;
import java.util.Set;

public class SocksMerchantSolution {

    public static int sockMerchant(int socksAmount, int[] socks) {
        Set<Integer> indexList = new HashSet<>();
        int socksCount = 0;
        for (int i = 0; i < socksAmount; i++) {
            for (int j = i + 1; j < socksAmount; j++) {
                if (!indexList.contains(j) && !indexList.contains(i)) {
                    if (socks[i] == socks[j]) {
                        socksCount++;
                        indexList.add(i);
                        indexList.add(j);
                    }
                }
            }
        }
        return socksCount;
    }
}
