import java.util.*;

class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int need = (n + 1) / 2; // ⌈n/2⌉ troops need to be lucky
        List<Integer> additions = new ArrayList<>();

        // Step 1: Calculate additions needed for each troop
        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                // Already lucky → no need to add soldiers
                need--;
            } else {
                // Soldiers needed to make it a multiple of k
                additions.add(k - (soldiers % k));
            }
        }

        // Step 2: If already enough lucky troops
        if (need <= 0) return 0;

        // Step 3: Sort to pick smallest additions first
        Collections.sort(additions);

        // Step 4: Add smallest possible soldiers until need is met
        int totalAdded = 0;
        for (int i = 0; i < need; i++) {
            totalAdded += additions.get(i);
        }

        return totalAdded;
    }
}