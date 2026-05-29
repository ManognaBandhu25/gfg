class Solution:
    def validGroups(self, s):
        # code here
        n = len(s)
        
        pref = [0] * (n)
        pref[0] = int(s[0])
        
        for i in range(1, len(s)):
            pref[i] = pref[i-1] + int(s[i])
            
        
        dp = {}
        
        def solve(i, prev_sum):
            
            if i == n:
                return 1
            
            if (i, prev_sum) in dp:
                return dp[(i, prev_sum)]
            
            ans = 0
            for j in range(i, n):
                curr_sum = pref[j] - (pref[i-1] if i-1>=0 else 0)
                
                if curr_sum >= prev_sum:
                    ans += solve(j+1, curr_sum)
                    
            
            dp[(i, prev_sum)] = ans
            return ans
            
        return solve(0, 0)