class Solution {
    public List<String> generateParenthesis(int n) {
        int open = 0;
        int close = 0;
        StringBuilder tmp = new StringBuilder();
        List<String> ans = new ArrayList<>();
        fun(open, close, n, tmp, ans);
        return ans;
    }
    public void fun(int open, int close, int n, StringBuilder tmp, List<String> ans){
        if(open == n && close == n){
            ans.add(tmp.toString());
            return;
        }else{
            //open
            if(open < n){
            tmp.append('(');
            fun(open + 1, close, n, tmp, ans);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        //close
            if(close < open){
            tmp.append(')');
            fun(open, close + 1, n, tmp, ans);
            tmp.deleteCharAt(tmp.length() - 1);
        }
     }
        return;
    }
}