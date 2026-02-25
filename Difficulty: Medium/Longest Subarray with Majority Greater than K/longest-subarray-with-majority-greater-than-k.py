class Solution:
    def longestSubarray(self, arr, k):
        prefix_sum = 0
        max_len = 0
        first_occurrence = {}
        
        for i in range(len(arr)):
            if arr[i] > k:
                prefix_sum += 1
            else:
                prefix_sum -= 1
                
             # If prefix sum > 0, whole subarray [0..i] is valid
            if prefix_sum > 0:
                max_len = i + 1
            else:
                # Store first occurrence
                if prefix_sum not in first_occurrence:
                    first_occurrence[prefix_sum] = i
                
                # Check if (prefix_sum - 1) exists
                if (prefix_sum - 1) in first_occurrence:
                    max_len = max(max_len, i - first_occurrence[prefix_sum - 1])
                    
        return max_len