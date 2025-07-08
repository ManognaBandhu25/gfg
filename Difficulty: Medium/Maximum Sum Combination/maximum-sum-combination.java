import java.util.*;

class Solution {
    class Pair {
        int sum;
        int i, j;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.sum - p1.sum);
        Set<String> visited = new HashSet<>();

        int i = n - 1;
        int j = n - 1;
        maxHeap.add(new Pair(a[i] + b[j], i, j));
        visited.add(i + "," + j);

        while (k-- > 0 && !maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.add(current.sum);
            int x = current.i;
            int y = current.j;

            if (x - 1 >= 0 && !visited.contains((x - 1) + "," + y)) {
                maxHeap.add(new Pair(a[x - 1] + b[y], x - 1, y));
                visited.add((x - 1) + "," + y);
            }

            if (y - 1 >= 0 && !visited.contains(x + "," + (y - 1))) {
                maxHeap.add(new Pair(a[x] + b[y - 1], x, y - 1));
                visited.add(x + "," + (y - 1));
            }
        }

        return result;
    }
}
