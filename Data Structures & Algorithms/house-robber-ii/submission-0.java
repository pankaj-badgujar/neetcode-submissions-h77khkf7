class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2){
            return nums[0];
        }
        
        int withoutLast = helper(0, nums.length - 2, nums);
        int withoutFirst = helper(1, nums.length - 1, nums);

        return Math.max(withoutFirst, withoutLast);
        
    }

    private int helper(int start, int end, int[] nums){
        int rob1 = 0, rob2 = 0; // [rob1, rob2, n , n +1 ..]

        for (int i = start; i <= end; i++){
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
