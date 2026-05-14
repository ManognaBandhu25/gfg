class Solution:
    def LPS(self, s):
        n = len(s)
        lps = [0]*n
        
        j, i = 0, 1
        
        while i<n:
            if s[i] == s[j]:
                j+=1
                lps[i]=j
                i+=1
            else:
                if j:
                    j=lps[j-1]
                else:
                    i+=1
                    
        return lps
    def search(self, a, b):
        n = len(a)
        m = len(b)
        lps = self.LPS(b)
        # print(lps)
        i, j = 0, 0
        ans = []
        
        while i<n:
            if a[i]==b[j]:
                i+=1
                j+=1
            
            if j==m:
                ans.append(i-m)
                j = lps[j-1]
            
            elif i<n and a[i]!=b[j]:
                if j:
                    j = lps[j-1]
                else:
                    i+=1
                    
        return ans