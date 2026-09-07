class Solution {
    private void helper(int[] nums, int l, int r){
        while (l < r){
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;

            r--;
            l++;
        }

    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        helper(nums, 0, nums.length - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, nums.length - 1);
    }
}