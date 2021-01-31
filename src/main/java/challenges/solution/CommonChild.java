package challenges.solution;

public class CommonChild {
    static int commonChild(String s1, String s2) {
        int[][] childLength = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    childLength[i + 1][j + 1] = childLength[i][j] + 1;
                } else {
                    childLength[i + 1][j + 1] = Math.max(childLength[i + 1][j], childLength[i][j + 1]);
                }
            }
        }

        return childLength[s1.length()][s2.length()];
    }
}
