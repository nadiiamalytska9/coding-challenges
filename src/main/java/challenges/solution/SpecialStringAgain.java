package challenges.solution;

public class SpecialStringAgain {
    static long substrCount(int n, String s) {
        int totalSpecialSubstringsCount = n;
        int consecutiveCharactersCount = 1;
        int midIndex = -1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                totalSpecialSubstringsCount += consecutiveCharactersCount;
                consecutiveCharactersCount++;

                if (midIndex > 0) {
                    if ((midIndex - consecutiveCharactersCount) >= 0 &&
                            s.charAt(midIndex - consecutiveCharactersCount) == s.charAt(i)) {
                        totalSpecialSubstringsCount++;
                    } else {
                        midIndex = -1;
                    }
                }
            } else {
                consecutiveCharactersCount = 1;

                if (((i - 2) >= 0) && s.charAt(i - 2) == s.charAt(i)) {
                    totalSpecialSubstringsCount++;
                    midIndex = i - 1;
                } else {
                    midIndex = -1;
                }
            }
        }
        return totalSpecialSubstringsCount;
    }
}
