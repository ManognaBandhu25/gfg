class Solution {
    public int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        final int INF = 1000; 

        for (int i = 0; i <= n; i++) dp[i] = INF;
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (isValid(sub)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n] >= INF ? -1 : dp[n];
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return false; 
        long num = Long.parseLong(s, 2); 

        if (num == 0) return false;

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
