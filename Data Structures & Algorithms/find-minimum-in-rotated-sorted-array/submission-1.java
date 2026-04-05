class Solution {
    public int findMin(int[] nums) {
        // the minimum is the rotation start
        // say we start with binary search and find mid

        // if mid is greater than right, we move l as m + 1
        // if mid is less than right, that means rotator is in left subarray 
        // we move r as m  and check
        // when l,m,r all point to same number that is the min.

        int l = 0, r = nums.length - 1;
        while(l < r){
            int m = l + (r-l)/2;

            if(nums[m] > nums[r]){
                l = m + 1;
            } else if (nums[m] < nums[r]){
                r = m;
            }
        }
        return nums[l];
    }
}
