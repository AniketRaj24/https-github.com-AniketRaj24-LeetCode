class Solution {
    public int threeSumClosest(int[] nums, int target) {
         int currsum = 0;
        Arrays.sort(nums);
        int closesum = nums[0]+nums[1]+nums[2];

        for(int i = 0; i< nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;

            while(j<k){
               currsum = nums[i]+nums[j]+nums[k];
               int sum1 = currsum - target;
               int sum2 = closesum - target;
            //    closesum = currsum-target;
                if(Math.abs(sum1) < Math.abs(sum2)){
                    closesum = currsum;
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
        return closesum;
    }
}

