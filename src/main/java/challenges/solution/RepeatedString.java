package challenges.solution;

public class RepeatedString {
    static long repeatedString(String s, long n) {
        long fullStringsNumber = n / s.length();
        long restNumber = n % s.length();

        if (!s.contains("a")) return 0;
        return s.length() > n ? count(s, restNumber)
                : fullStringsNumber * count(s, s.length()) + count(s, restNumber);
    }

    private static long count(String s, long end) {
        int repeatedStringsCount = 0;
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == 'a') repeatedStringsCount++;
        }
        return repeatedStringsCount;
    }
}
