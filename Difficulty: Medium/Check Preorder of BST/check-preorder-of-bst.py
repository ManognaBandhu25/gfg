class Solution:
    def canRepresentBST(self, arr):
        # code here
        s = [(-sys.maxsize, sys.maxsize)]
        for i in arr:
            while s:
                pop = s.pop()
                if pop[0] < i < pop[1]:
                    s.append((i, pop[1]))
                    s.append((pop[0], i))
                    break   
        return s != []