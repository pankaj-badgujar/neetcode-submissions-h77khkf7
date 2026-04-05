class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1, b = nums2;
        if (a.length > b.length) { // ensure a is smaller
            a = nums2;
            b = nums1;
        }

        int total = a.length + b.length;
        int half = total / 2;

        int l = 0, r = a.length; // NOTE: r = a.length (not a.length - 1)

        while (l <= r) {
            int i = l + (r - l) / 2;     // i = # of elements from a on left
            int j = half - i;            // j = # of elements from b on left

            int aLeft  = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int aRight = (i == a.length) ? Integer.MAX_VALUE : a[i];

            int bLeft  = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int bRight = (j == b.length) ? Integer.MAX_VALUE : b[j];

            if (aLeft <= bRight && bLeft <= aRight) {
                // correct partition
                if (total % 2 == 1) {
                    return Math.min(aRight, bRight);
                } else {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        // should never reach here for valid inputs
        return 0.0;
    }
}