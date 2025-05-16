//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        
        int k = arr.length;
        int n = arr[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int max = Integer.MIN_VALUE;
        int start = 0, end = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            minHeap.offer(new int[]{arr[i][0], i, 0});
            max = Math.max(max, arr[i][0]);
        }

        while (minHeap.size() == k) {
            int[] curr = minHeap.poll();
            int min = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (col + 1 < n) {
                int nextVal = arr[row][col + 1];
                minHeap.offer(new int[]{nextVal, row, col + 1});
                max = Math.max(max, nextVal);
            } else {
                break; 
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(start);
        res.add(end);
        return res;
    }
}
