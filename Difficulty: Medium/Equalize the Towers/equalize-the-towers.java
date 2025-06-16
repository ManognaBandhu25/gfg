class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;

        // Find the minimum and maximum height
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        int ans = Integer.MAX_VALUE;

        // Binary search for optimal height
        while (low <= high) {
            int mid = low + (high - low) / 2;

            long cost1 = totalCost(heights, cost, mid);
            long cost2 = totalCost(heights, cost, mid + 1);

            if (cost1 < cost2) {
                high = mid - 1;
                ans = (int)Math.min(ans, cost1);
            } else {
                low = mid + 1;
                ans = (int)Math.min(ans, cost2);
            }
        }

        return ans;
    }

    private long totalCost(int[] heights, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += (long) Math.abs(heights[i] - target) * cost[i];
        }
        return total;
    }
}

