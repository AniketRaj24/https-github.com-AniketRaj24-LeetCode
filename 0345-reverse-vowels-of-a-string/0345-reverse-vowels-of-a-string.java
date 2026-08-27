class Solution {
    private boolean isVowels(char c){
        if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U'){
            return true;
        }else{
            return false;
        }
    }
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            while(start < end && !isVowels(arr[start])){
                start++;
            }
             while(start < end && !isVowels(arr[end])){
                end--;
            }
            if(start < end){
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return new String(arr);
    }
}