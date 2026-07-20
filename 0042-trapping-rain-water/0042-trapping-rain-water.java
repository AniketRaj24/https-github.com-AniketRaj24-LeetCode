class Solution {
    public int trap(int[] height) {
        //Two Pointer Approach
        int n = height.length;
        int totalwater = 0;
        int leftmax = 0;
        int rightmax = 0;
        int start = 0;
        int end = n-1;

        while(start < end){
            leftmax = Math.max(leftmax, height[start]);
            rightmax = Math.max(rightmax, height[end]);

            if(leftmax < rightmax){
                totalwater += leftmax - height[start];
                start++;
            }else{
                totalwater += rightmax - height[end];
                end--;
            }
        }
        return totalwater;

    }
}