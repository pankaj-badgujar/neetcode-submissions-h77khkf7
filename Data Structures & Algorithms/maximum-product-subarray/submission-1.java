class Solution {
    public int maxProduct(int[] nums) {
        int curMin = 1, curMax = 1, res = nums[0];
        

        for (int n : nums){
            int tempCurMax = curMax;
            curMax = Math.max(n, Math.max(curMax * n, curMin * n));
            curMin = Math.min(n, Math.min(tempCurMax * n, curMin * n));
            

            res = Math.max(res, curMax);

        }

        return res;
        
    }
}
