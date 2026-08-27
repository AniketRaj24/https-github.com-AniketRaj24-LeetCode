class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m) return false;

        int[] newS = new int [256];
        int[] newT = new int [256];

        for(int i = 0; i < n; i++){
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(newS[a] != newT[b]){
                return false;
            }
            newS[a] = i + 1;
            newT[b] = i + 1;
        }
        return true;
    }
}