class Solution:
    def countWays(self, n, sum):
        if n==1 and sum>=10:
            return -1
        dp = {}
        def solve(cnt,add):
            if cnt==n:
                if add==sum:
                    return 1
                else:
                    return 0
            if (cnt,add) in dp:
                return dp[(cnt,add)]
            ans=0
            for i in range(10):
                ans+=(solve(cnt+1,add+i))
            dp[(cnt,add)] = ans
            return ans
        res=0
        for i in range(1,10):
            res += solve(1,i)
        return -1 if res==0 else res