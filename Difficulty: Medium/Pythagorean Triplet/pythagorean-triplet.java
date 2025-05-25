import java.util.HashSet;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;

        HashSet<Integer> squares = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
            squares.add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (squares.contains(sum)) {
                    return true;
                }
            }
        }

        return false;
    }
}
