import java.util.*;

class Solution {
    public int vowelCount(String s) {
        // Set of vowels
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        // Map to count occurrences of each vowel
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count occurrences of each vowel in the string
        for (char c : s.toCharArray()) {
            if (vowelSet.contains(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        // If no vowels, return 0
        if (freqMap.isEmpty()) return 0;

        // Get list of vowel frequencies
        List<Integer> counts = new ArrayList<>(freqMap.values());

        // Compute product of frequencies (number of ways to pick one occurrence per vowel)
        int selectionWays = 1;
        for (int count : counts) {
            selectionWays *= count;
        }

        // Compute factorial of number of unique vowels (for permutations)
        int permutationWays = factorial(counts.size());

        return selectionWays * permutationWays;
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
}
