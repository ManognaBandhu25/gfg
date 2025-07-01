import java.util.*;

class Solution {
    public int substrCount(String s, int k) {
        if (s == null || s.length() < k) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the map
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Remove the character that goes out of the window
            if (i >= k) {
                char toRemove = s.charAt(i - k);
                map.put(toRemove, map.get(toRemove) - 1);
                if (map.get(toRemove) == 0) {
                    map.remove(toRemove);
                }
            }

            // When the window size reaches k, check if it has k - 1 distinct characters
            if (i >= k - 1) {
                if (map.size() == k - 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
