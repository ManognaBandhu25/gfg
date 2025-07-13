class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        
        // Each element is at least a subsequence of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Find the length of the LIS using DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // Find the maximum length of LIS
        int lisLength = 0;
        for (int i = 0; i < n; i++) {
            lisLength = Math.max(lisLength, dp[i]);
        }

        // Reconstruct one LIS with max length
        int[] lis = new int[lisLength];
        int index = lisLength - 1;
        int prev = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0 && index >= 0; i--) {
            if (dp[i] == index + 1 && arr[i] < prev) {
                lis[index] = arr[i];
                prev = arr[i];
                index--;
            }
        }

        // Mark elements in LIS using a HashSet
        java.util.HashSet<Integer> lisSet = new java.util.HashSet<>();
        for (int val : lis) {
            lisSet.add(val);
        }

        // Calculate total sum and subtract LIS sum
        int totalSum = 0, lisSum = 0;
        for (int val : arr) {
            totalSum += val;
            if (lisSet.contains(val)) {
                lisSum += val;
                lisSet.remove(val); // handle duplicates
            }
        }

        return totalSum - lisSum;
    }
}
