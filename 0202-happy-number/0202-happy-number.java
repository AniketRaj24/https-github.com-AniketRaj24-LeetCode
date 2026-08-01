class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (true) {
            slow = fun(slow);
            fast = fun(fun(fast));

            if (slow == fast) {
                if (slow == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    private int fun(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum = sum + digit * digit;
        }
        return sum;
    }
}