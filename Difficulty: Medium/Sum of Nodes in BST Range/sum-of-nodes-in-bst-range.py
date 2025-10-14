"""
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
"""

class Solution:
    def nodeSum(self, root, l, r):
        # code here
        res =  0 
        def dfs(node):
            nonlocal  res
            if not node:
                return 
            d = node.data
            if l<=d<=r:
                res+=d
            dfs(node.left)
            dfs(node.right)
            return 
        dfs(root)
        return res
        
        
