class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        long totalSum = 0;
        long prev = 0;

        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            prev = prev * 10 + num * (i + 1);
            totalSum += prev;
        }

        return (int) totalSum;
    }
}
