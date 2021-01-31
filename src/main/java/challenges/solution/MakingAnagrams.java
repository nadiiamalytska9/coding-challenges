package challenges.solution;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {
    static int makeAnagram(String a, String b) {
        int deletedCharactersNumber = 0;
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : a.toCharArray()) {
            int ct = count.getOrDefault(ch, 0);
            count.put(ch, (ct + 1));
        }

        for (char ch : b.toCharArray()) {
            int ct = count.getOrDefault(ch, 0);
            count.put(ch, (ct - 1));
        }
        for (Integer v : count.values()) {
            deletedCharactersNumber += Math.abs(v);
        }
        return deletedCharactersNumber;
    }
}
