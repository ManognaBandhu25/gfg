class Solution:
    def processQueries(self, arr, queries):
        # code here
        pre = [1] * len(arr)
        suff = [1] * len(arr)
        
        for i in range(1, len(arr)):
            if arr[i-1] >= arr[i]:
                pre[i] += pre[i-1]
                
                
        for i in range(len(arr)-1, 0, -1):
            if arr[i-1] <= arr[i]:
                suff[i-1] += suff[i]
                
        res = []
        for l, r in queries:
            if suff[l] + pre[r] - 1 >= r - l + 1:
                res.append(True)
            else:
                res.append(False)
        return res