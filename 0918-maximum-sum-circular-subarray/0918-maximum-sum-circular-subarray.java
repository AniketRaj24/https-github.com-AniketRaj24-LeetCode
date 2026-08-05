class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxend = nums[0], minend = nums[0], maxsum = nums[0], minsum = nums[0], total = nums[0], ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            maxend = Math.max(maxend + nums[i], nums[i]);
            minend = Math.min(minend + nums[i], nums[i]);

            maxsum = Math.max(maxsum, maxend);
            minsum = Math.min(minsum, minend);

            total = total + nums[i];
        }
        if(maxsum < 0) return maxsum;
        ans = Math.max(maxsum, total - minsum);
        return ans;
    }
}