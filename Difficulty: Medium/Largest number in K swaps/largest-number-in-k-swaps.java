//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



        // code here.
class Solution {
    static String max;

    public String findMaximumNum(String s, int k) {
        max = s;
        char[] arr = s.toCharArray();
        helper(arr, k);
        return max;
    }

    private void helper(char[] arr, int k) {
        if (k == 0) return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    swap(arr, i, j);
                    String current = new String(arr);
                    if (current.compareTo(max) > 0) {
                        max = current;
                    }
                    helper(arr, k - 1);
                    swap(arr, i, j); // backtrack
                }
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
   


