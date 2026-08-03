class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> map = new HashMap<>();
       int n = s.length();
       int low = 0;
       int result = 0;

       for(int high = 0; high < n; high++){
        char a = s.charAt(high);
        map.put(a, map.getOrDefault(a, 0)+ 1);

       while(map.get(a) > 1){
        char b = s.charAt(low);
        map.put(b, map.get(b) - 1);
        if(map.get(b) == 0){
            map.remove(b);
        }
        low++;
       }
       result = Math.max(result, high - low + 1);

       }
       return result;

    }
}