class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> st = new ArrayDeque<>(); // stores indices, not values
        st.push(0);

        for (int i = 1; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!st.isEmpty() && nums[st.peek()] < num) {
                int idx = st.pop();
                result[idx] = num;
            }
            if (i < n) {
                st.push(i);
            }
        }
        return result;
    }
}