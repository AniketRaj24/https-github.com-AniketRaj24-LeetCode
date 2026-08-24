class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> Map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (Map.containsKey(complement)) {
                return new int[]{Map.get(complement), i};
            }
            Map.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }
}