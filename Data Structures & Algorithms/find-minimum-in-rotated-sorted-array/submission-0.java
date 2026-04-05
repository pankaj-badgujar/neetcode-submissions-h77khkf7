class Solution {
    public int findMin(int[] nums) {
        // the minimum is the rotation start

        // say we start with binary search and find mid
        // check mid - 1 and mid +2 to identify if its the rotator.
        // if not, and mid is greater than right, we move l

        // if mid is less than right, that means rotator is in left subarray 
        // we move r as m - 1 and check if new r is not more than left, if it is, then m is rotator hence the min 

        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.min(nums[0], nums[1]); 
        }

        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = l + (r-l)/2;

            if (m == r && m == l){
                return nums[m];
            }

            if(nums[m] > nums[r]){
                l = m + 1;
            } else if (nums[m] < nums[r]){
                r = m;
            }
        }
        return 0;
    }
}
