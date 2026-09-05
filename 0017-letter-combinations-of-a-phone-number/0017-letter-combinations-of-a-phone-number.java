class Solution {
    HashMap <Character, String> f = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        f.put('2', "abc");
        f.put('3', "def");
        f.put('4', "ghi");
        f.put('5', "jkl");
        f.put('6', "mno");
        f.put('7', "pqrs");
        f.put('8', "tuv");
        f.put('9', "wxyz");
        int n = digits.length();
        int idx = 0;
        StringBuilder diary = new StringBuilder();
        List<String> ans = new ArrayList<>();
        fun(digits, n, idx, diary, ans);
        return ans;
    }
    public void fun(String digits, int n, int idx, StringBuilder diary, List<String> ans){
        if(idx == n){
            ans.add(diary.toString());
            return;
        }
        else{
            String choice = f.get(digits.charAt(idx));
            for(int j = 0; j < choice.length(); j++){
                diary.append(choice.charAt(j));
                fun(digits, n, idx+1, diary, ans);
                diary.deleteCharAt(diary.length()-1);
            }
        }
        return;
    }
}