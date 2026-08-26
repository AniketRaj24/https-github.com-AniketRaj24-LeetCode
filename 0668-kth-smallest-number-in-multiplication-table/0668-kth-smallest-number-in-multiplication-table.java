class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int res = -1;

        while (low <= high) {
            int guess = low + (high - low) / 2;
            int count = countLessEqual(guess, m, n);

            if (count < k) {
                low = guess + 1;
            } else {
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }

    // Counts how many values in the m x n multiplication table are <= x
    private int countLessEqual(int x, int m, int n) {
        int count = 0;
        for (int row = 1; row <= m; row++) {
            count += Math.min(n, x / row);
        }
        return count;
    }
}