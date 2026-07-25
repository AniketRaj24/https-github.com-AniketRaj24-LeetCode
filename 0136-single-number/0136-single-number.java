class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i = 0; i < nums.length; i++){
            int element = nums[i];
            xor = xor ^ element;
        }
        return xor;
    }
}