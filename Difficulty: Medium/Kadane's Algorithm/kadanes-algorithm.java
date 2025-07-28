class Solution {
    int maxSubarraySum(int[] nums) {

        int n = nums.length;

        int curr = nums[0];
        int maxsum = nums[0];

        for(int i = 1; i < n; i++) {
            curr = Math.max(nums[i] , curr + nums[i]);
            maxsum = Math.max(maxsum, curr);
        }
        return maxsum;
    }
}
