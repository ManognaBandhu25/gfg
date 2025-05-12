//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        java.util.Arrays.sort(meetings, java.util.Comparator.comparingInt(a -> a[0]));

        java.util.PriorityQueue<Integer> free = new java.util.PriorityQueue<>();
        for (int i = 0; i < n; i++) free.add(i);

        java.util.PriorityQueue<long[]> busy = new java.util.PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1])
        );

        int[] count = new int[n];

        for (int[] m : meetings) {
            int start = m[0], duration = m[1] - m[0];

            while (!busy.isEmpty() && busy.peek()[0] <= start)
                free.add((int) busy.poll()[1]);

            if (!free.isEmpty()) {
                int room = free.poll();
                busy.add(new long[]{start + duration, room});
                count[room]++;
            } else {
                long[] next = busy.poll();
                busy.add(new long[]{next[0] + duration, next[1]});
                count[(int) next[1]]++;
            }
        }

        int max = 0, res = 0;
        for (int i = 0; i < n; i++)
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        return res;
    }
}




//{ Driver Code Starts.
// } Driver Code Ends