class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int i = 0; i < candies.length; i++){
            int candy = candies[i];
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> result = new ArrayList<>();
        /*We can also write "for(int candy:candies)" in the place of
        for(int i = 0; i < candies.length; i++){
             int candy = candies[i];
             } */ 
        for(int candy : candies){
            if(candy + extraCandies >= maxCandies){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}