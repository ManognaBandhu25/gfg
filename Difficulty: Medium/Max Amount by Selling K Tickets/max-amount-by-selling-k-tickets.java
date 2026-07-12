class Solution {
    public int maxAmount(int[] arr, int k) {
        // code here
        long MOD = 1000000007L;

        // Max Heap to always get the ticket with the highest value
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Insert all ticket values into the max heap
        for (int tickets : arr) {
            pq.add(tickets);
        }

        long total = 0;

        // Sell exactly k tickets (or until no valid tickets remain)
        while (k > 0 && !pq.isEmpty()) {

            // Get the highest available ticket value
            int curr = pq.poll();

            // If the highest value is 0 or less, no more profit can be made
            if (curr <= 0) {
                break;
            }

            // Add the current ticket value to the total profit
            total = (total + curr) % MOD;

            // After selling, its value decreases by 1 and is added back
            pq.add(curr - 1);

            // One ticket has been sold
            k--;
        }

        // Return the maximum profit
        return (int) total;
    }
}