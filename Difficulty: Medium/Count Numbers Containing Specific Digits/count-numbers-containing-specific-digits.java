import java.util.*;

class Solution {
    public int countValid(int n, int[] arr) {
        Set<Integer> requiredDigits = new HashSet<>();
        for (int d : arr) requiredDigits.add(d);
        
        // Count total valid n-digit numbers
        int total = 9 * (int)Math.pow(10, n - 1);
        
        // Count numbers with NO required digits
        int countWithout = countWithoutDigits(n, requiredDigits);
        
        return total - countWithout;
    }

    private int countWithoutDigits(int n, Set<Integer> requiredDigits) {
        int[] digits = new int[10];
        for (int d = 0; d < 10; d++) {
            if (!requiredDigits.contains(d)) digits[d] = 1;
        }

        // memo[i][tight][leadingZero] to avoid recomputation
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, n, true, true, digits, memo);
    }

    private int dfs(int pos, int n, boolean tight, boolean leadingZero, int[] allowed, Map<String, Integer> memo) {
        if (pos == n) return leadingZero ? 0 : 1;

        String key = pos + "-" + tight + "-" + leadingZero;
        if (memo.containsKey(key)) return memo.get(key);

        int res = 0;
        int start = 0;
        int end = 9;

        for (int d = start; d <= end; d++) {
            if (allowed[d] == 0) continue;
            if (leadingZero && d == 0) continue;
            res += dfs(pos + 1, n, false, false, allowed, memo);
        }

        memo.put(key, res);
        return res;
    }
}
