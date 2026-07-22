class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0;
        int f[] = new int[256];
        int ans = 0;
        int maxcnt = 0;

        for(int high = 0; high < n; high++){
            f[s.charAt(high)]++;
            maxcnt = Math.max(maxcnt, f[s.charAt(high)]);
            int len = high - low + 1;
            int diff = len - maxcnt;
// 'low' jb tk result glt aayega 
            while(diff > k){
                f[s.charAt(low)]--;
                low++;
                len = high - low + 1;
                diff = len - maxcnt;
            }
            ans = Math.max(ans, len);
        }
        return ans;
        
    }
}