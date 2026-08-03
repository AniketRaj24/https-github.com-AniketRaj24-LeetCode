class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]){
                min = Math.min(min, nums[i]);
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] > nums[i+1]){
                max = Math.max(max, nums[i]);
            }
        }
        if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) return 0;

        int start = 0; 
        int end = n - 1;

        for(; start < n; start++){
            if(nums[start] > min) break;
        }
        for(; end >= 0; end--){
            if(nums[end] < max) break;
        }
        return end - start + 1;
    }
}