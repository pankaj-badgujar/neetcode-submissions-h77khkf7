class Solution {

    private int quickSelect(int[] nums, int k, int l, int r){
        // assign p to 0.. iterate
        // if nums[i] < pivot, it stays there p moves
        // if not, then  p stays there

        // find a pivot - last el of the arr
        int pivot = nums[r];
        int p = l;

        for (int i = l; i < r; i++){
            if (nums[i] <= pivot){
                // swap
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;

                p++;
            }
        }
        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;

        if (k < p){
            return quickSelect(nums, k, l, p - 1);
        } else if ( k > p){
            return quickSelect(nums, k, p + 1, r);
        }
        return nums[p];
    }


    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }
}
