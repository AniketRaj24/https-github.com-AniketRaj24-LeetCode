class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{ first(nums, target), last(nums, target)};
    }
    private int first(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int res = -1;
        while(low <= high){
            int guess = (low + high)/2;
            if(nums[guess] < target){
                low = guess + 1;
            }
            else if(nums[guess] > target){
                high = guess - 1;
            }
            else{
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
    private int last(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int res = -1;
        while(low <= high){
            int guess = (low + high)/2;
            if(nums[guess] < target){
                low = guess + 1;
            }
            else if(nums[guess] > target){
                high = guess - 1;
            }
            else{
                res = guess;
                low = guess + 1;
            }
        }
        return res;
    }
}