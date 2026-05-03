class Solution:
    def sortBySetBitCount(self, arr):
        def countBits(x):
            count = 0
            while x:
                x = x & (x - 1)
                count += 1
            return count
        
        # Max bits for typical integers (0–32)
        buckets = [[] for _ in range(33)]
        
        # Fill buckets (stable: append keeps original order)
        for num in arr:
            bits = countBits(num)
            buckets[bits].append(num)
        
        # Collect from highest set bits to lowest
        result = []
        for i in range(32, -1, -1):
            result.extend(buckets[i])
        
        return result

