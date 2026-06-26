class Solution:
    def countWays(self, s1, s2):
        MODULO = 10**9 + 7
        m, n = len(s1), len(s2)
        dp_row = [1] * (m + 1)
        for i in range(1, n + 1):
            next_dp_row = [0] * (m + 1)
            for j in range(i, m + 1):
                next_dp_row[j] = next_dp_row[j - 1]
                if s2[i - 1] == s1[j - 1]:
                    next_dp_row[j] = (next_dp_row[j] + dp_row[j - 1]) % MODULO
            dp_row = next_dp_row
        return dp_row[m]
        
