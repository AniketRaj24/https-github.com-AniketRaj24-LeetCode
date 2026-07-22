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

//Another Approach....
 /* int currsum = 0;
        Arrays.sort(nums);
        int clossum = nums[0]+nums[1]+nums[2];

        for(int i = 0; i< nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;

            while(j<k){
               int  currsum = nums[i]+nums[j]+nums[k];
            //    clossum = currsum-target;
                if(Math.abs(currsum - target)<Math.abs(clossum-target)){
                    clossum = currsum;
                } 

                if(currsum>target){
                    k--;
                }else if(currsum<target){
                    j++;
                }else{
                    return currsum;
                }
            }
        }
        return clossum; */