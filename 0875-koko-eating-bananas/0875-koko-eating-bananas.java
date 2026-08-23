class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 1;
        for(int i = 0; i < n; i++){
            if(piles[i] > high){
                high = piles[i];
            }
        }
        int result = -1;
        while(low <= high){
            int guess = (low + high)/2;
            long hours = fun(piles,n,guess);
            if(hours > h){
                low = guess + 1;
            }else{
                result = guess;
                high = guess - 1;
            }
        }
        return result;
    }
    private long fun(int[] piles, int hours, int speed){
        int n = piles.length;
        long total = 0;
        for(int i = 0; i < n; i++){
            total = total + piles[i]/speed;
            if(piles[i] % speed != 0){
                total++;
            }
           
        }
         return total;
    }
}