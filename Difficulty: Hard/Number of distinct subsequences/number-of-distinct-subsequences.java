class Solution {
    
    private int mod = 1000000007;
    int distinctSubseq(String str) {
        // code here
        int n = str.length();
        long[] dp = new long[n+1];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        dp[0] = 1; 
        
        for(int i=1;i<=n;i++) {
            int x = str.charAt(i-1)-'a';
            dp[i] = (2*dp[i-1]) % mod; 
        
            
            if(last[x] != -1) {
                dp[i] = (dp[i] - dp[last[x]-1] + mod) % mod;
            }
            
            last[x] = i;
        }
        
        return (int)dp[n];
    }
}