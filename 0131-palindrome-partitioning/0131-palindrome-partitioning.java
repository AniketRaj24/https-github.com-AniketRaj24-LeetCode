class Solution {
    public boolean isPalindrome(String s){
        int low = 0;
        int high = s.length()-1;
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<String> diary = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        int idx = 0;
        fun(s,n,diary,res,idx);
        return res;

    }
    public void fun(String s, int n, List<String> diary, List<List<String>> res, int idx){
        if(idx == n){
            res.add(new ArrayList<>(diary));
            return;
        }
        for(int i = idx; i < n; i++){
            String sub = s.substring(idx, i+1);
            if(isPalindrome(sub)){
                diary.add(sub);
                fun(s, n, diary, res, i+1);
                diary.remove(diary.size()-1);
            }
        }
    }
}