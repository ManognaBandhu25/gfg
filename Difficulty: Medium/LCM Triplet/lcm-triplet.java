class Solution {
    // Function to calculate GCD
    private long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Function to calculate LCM
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    int lcmTriplets(int n) {
        // If n is 1 or 2, handle small cases directly
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;

        long maxLCM = 0;

        // If n is odd, try (n, n-1, n-2)
        if (n % 2 != 0) {
            maxLCM = lcm(n, lcm(n - 1, n - 2));
        } else {
            // If n is even
            // Try two triplets to avoid cases with common factors
            long option1 = lcm(n, lcm(n - 1, n - 3)); // skip n-2 if divisible by 2
            long option2 = lcm(n - 1, lcm(n - 2, n - 3));
            maxLCM = Math.max(option1, option2);
        }

        return (int) maxLCM;
    }
}
