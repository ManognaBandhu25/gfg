class Solution:
	def maxSubstring(self, s):
		# code here\
		c = 0
        mini = None
        res = -1
        for i in s:
            if i == '1':
                c -= 1
            else:
                c += 1
                mini = min(mini, c) if mini != None else c
                res = max(abs(mini - c) + 1, res)
        return res
		