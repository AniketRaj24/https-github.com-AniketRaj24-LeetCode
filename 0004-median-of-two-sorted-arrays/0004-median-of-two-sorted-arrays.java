class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always perform binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int start = 0;
        int end = m;

        while (start <= end) {

            int part1 = (start + end) / 2;
            int part2 = (m + n + 1) / 2 - part1;

            int maxLeftNums1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int minRightNums1 = (part1 == m) ? Integer.MAX_VALUE : nums1[part1];

            int maxLeftNums2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int minRightNums2 = (part2 == n) ? Integer.MAX_VALUE : nums2[part2];

            // Correct partition found
            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {

                // Even number of elements
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftNums1, maxLeftNums2)
                            + Math.min(minRightNums1, minRightNums2)) / 2.0;
                }

                // Odd number of elements
                return Math.max(maxLeftNums1, maxLeftNums2);
            }

            // Move towards left
            else if (maxLeftNums1 > minRightNums2) {
                end = part1 - 1;
            }

            // Move towards right
            else {
                start = part1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}