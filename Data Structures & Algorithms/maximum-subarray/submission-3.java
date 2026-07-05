class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = nums[0];


        for (int i = 1; i < nums.length; i++){
            if (curSum < 0){
                // then we reset curSum
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            max = Math.max(max, curSum);
         
        }
        return max;

    }
}
