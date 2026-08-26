class Solution {
    private boolean fun(int[] candies, long candyPerChild, long k){
        long totalChild = 0;
        for(int i = 0; i < candies.length; i++){
            totalChild += candies[i] / candyPerChild;
        }
        return totalChild >= k;
    }
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        long low = 1;
        long high = 0;
        for(int i = 0; i < n; i++){
            high = Math.max(high, candies[i]);
        }
        if(high == 0) return 0;
        long res = 0;

        while(low <= high){
            long guess = (low + high)/2;
            if(fun(candies, guess, k)){
                res = guess;
                low = guess + 1;
            }else{
                high = guess - 1;
            }

        }
        return (int) res;
    }
}