class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();

        

        // Edge case for single-digit numbers

        if (n == 1) {

            ans.add(0);

        }

        

        // Starting digits can range from 1 to 9

        for (int i = 1; i <= 9; i++) {

            solve(n - 1, i, i, ans);

        }

        

        return ans;

    }

    

    private static void solve(int remainingDigits, int lastDigit, int cur, ArrayList<Integer> ans) {

        // Base case: full number constructed

        if (remainingDigits == 0) {

            ans.add(cur);

            return;

        }

        

        // Next digit must be strictly greater than the last digit

        for (int i = lastDigit + 1; i <= 9; i++) {

            solve(remainingDigits - 1, i, cur * 10 + i, ans);

        }
    }
}
