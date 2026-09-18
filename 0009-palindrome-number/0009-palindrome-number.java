class Solution {
    public boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        int original = num;
        int rev = 0;
        int n = num;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        return original == rev;
    }
}