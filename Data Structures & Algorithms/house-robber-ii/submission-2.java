class Solution {
    private int helper(int[] nums){
        int rob1 = 0, rob2 = 0;

        for (int n : nums){
            int newRob = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int fMax = helper(Arrays.copyOfRange(nums, 0, n - 1));
        
        int sMax = helper(Arrays.copyOfRange(nums, 1, n));

        return Math.max(fMax, sMax);
        
    }
}
