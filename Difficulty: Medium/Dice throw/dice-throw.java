class Solution {
    static int noOfWays(int m, int n, int x) {
        int[][] dp = new int[n + 1][x + 1];

        dp[0][0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            for (int sum = 1; sum <= x; sum++) {
                dp[dice][sum] = 0;
                for (int face = 1; face <= m && face <= sum; face++) {
                    dp[dice][sum] += dp[dice - 1][sum - face];
                }
            }
        }

        return dp[n][x];
    }

    public static void main(String[] args) {
        System.out.println(Solution.noOfWays(6, 3, 12)); 
        System.out.println(Solution.noOfWays(2, 3, 6));  
    }
};
