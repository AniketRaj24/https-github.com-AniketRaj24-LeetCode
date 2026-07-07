class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length-1;

        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                return new int [] {i+1, j+1};
            }if(sum < target){
                i++;
            }else if(sum > target){
                j--;
            }
        }
        return null;
        
    }
}