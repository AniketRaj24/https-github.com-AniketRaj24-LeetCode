class Solution {
    public int totalFruit(int[] f) {
        //f = fruits
        Map<Integer, Integer> count = new HashMap<>();
        int low = 0;
        int n = f.length;
        int result = -1;
        
        for(int high = 0; high < n; high ++){
            int c = f[high];
            count.put(c, count.getOrDefault(c, 0) + 1);

            while(count.size() > 2){
                int s = f[low];
                count.put(s, count.get(s) - 1);
                if(count.get(s) == 0){
                    count.remove(s);
                }
                low++;
            }
            result = Math.max(result, high - low + 1);
        }
        return result;
    }
}