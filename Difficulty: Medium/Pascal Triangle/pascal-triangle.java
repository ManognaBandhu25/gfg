//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java



class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        int mod = 1000000007; // Optional mod for large results
        
        row.add(1); // First element is always 1
        long prev = 1;

        for (int k = 1; k < n; k++) {
            // Using: C(n, k) = C(n, k-1) * (n-k)/k
            long curr = (prev * (n - k)) % mod;
            curr = (curr * modInverse(k, mod)) % mod;
            row.add((int) curr);
            prev = curr;
        }

        return row;
    }

    // Computes modular inverse using Fermat's Little Theorem
    long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    long power(long x, int y, int mod) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % mod;
            y = y >> 1;
            x = (x * x) % mod;
        }
        return res;
    }
}
