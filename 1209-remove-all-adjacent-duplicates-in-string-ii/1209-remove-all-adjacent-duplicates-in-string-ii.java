class Solution {
    static class Pair{
        char first;
        int second;
        Pair(char first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Deque<Pair> st = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
             char c = s.charAt(i);
             if(st.isEmpty()){
                st.push(new Pair(c,1));
                continue;
             }
             if(st.peek().first != c){
                st.push(new Pair(c,1));
                continue;
             }
             if(st.peek().second < (k-1)){
                Pair p = st.peek();
                st.pop();
                st.push(new Pair(p.first, p.second + 1));
                continue;
             }else{
                st.pop();
             }
        }
         StringBuilder result = new StringBuilder();
            while(!st.isEmpty()){
                 Pair p = st.peek();
                 st.pop();
                 while(p.second-- > 0){
                    result.append(p.first);
                 }
            }
            return result.reverse().toString();
    }
}