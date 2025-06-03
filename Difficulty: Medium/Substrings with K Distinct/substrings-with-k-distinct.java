// User function Template for Java

import java.util.*;

class Solution {
    int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    private int countAtMostK(String s, int k) {
        int left = 0, right = 0;
        int count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countSubstr("abc", 2)); // Output: 2
        System.out.println(sol.countSubstr("aba", 2)); // Output: 3
        System.out.println(sol.countSubstr("aa", 1));  // Output: 3
    }
}
