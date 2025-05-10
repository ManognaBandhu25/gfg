//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

import java.util.*;

class Solution {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] transformed = new int[n];

        // Step 1: Transform the array: +1 if arr[i] > k, else -1
        for (int i = 0; i < n; i++) {
            transformed[i] = arr[i] > k ? 1 : -1;
        }

        // Step 2: Use prefix sum and a hashmap to track first occurrences
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += transformed[i];

            // If prefix sum is positive, the entire subarray from 0 to i is valid
            if (prefixSum > 0) {
                maxLength = i + 1;
            } else {
                // If (prefixSum - 1) seen before, possible valid subarray exists
                if (firstOccurrence.containsKey(prefixSum - 1)) {
                    maxLength = Math.max(maxLength, i - firstOccurrence.get(prefixSum - 1));
                }
            }

            // Store the first occurrence of this prefix sum
            if (!firstOccurrence.containsKey(prefixSum)) {
                firstOccurrence.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends