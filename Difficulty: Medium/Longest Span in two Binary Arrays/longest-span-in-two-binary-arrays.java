
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n = a1.length;
        int[] diff = new int[n];

        // Create a difference array of a1 and a2
        for (int i = 0; i < n; i++) {
            diff[i] = a1[i] - a2[i];
        }

        // Map to store the first occurrence of prefix sum
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];

            // If prefix sum is 0, then subarray [0...i] has equal sum
            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            // If this prefixSum has been seen before, update maxLen
            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                // Store the first occurrence of this prefixSum
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
