class Solution {
    public int maximumSum(int[] arr) {
        int power = 0;
        int noPower = arr[0];
        int result = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            int v1 = arr[i];
            int v2 = noPower + arr[i];
            int v3 = power + arr[i];
            int v4 = noPower;
            noPower = Math.max(v1,v2);
            power = Math.max(v3,v4);
            result = Math.max(result, Math.max(noPower, power));
        }
        return result;
    }
}