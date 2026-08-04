class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = arr[0];
        int ans = arr[0];

        for(int i = 1; i < arr.length; i++){
            int v1 = arr[i] + noDelete;
            int v2 = arr[i] + oneDelete;
            oneDelete = Math.max(v2, noDelete);
            noDelete = Math.max(v1, arr[i]);
            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }
        return ans;

    }
}