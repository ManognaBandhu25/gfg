import java.util.*;

class Solution {
    public int totalElements(int[] arr) {
        int n = arr.length;
        int left = 0, right = 0, maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
