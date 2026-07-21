class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        long diff = Long.MAX_VALUE;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                long newDiff = Math.abs(target - sum);
                if(newDiff < diff){
                    diff = newDiff;
                    result = sum;
                } 
                if(sum < target){
                    left ++;
                }else if(sum > target){
                    right --;
                }else{
                    return sum;
                }
            }
        }
        return result;
    }
}