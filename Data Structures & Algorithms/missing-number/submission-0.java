class Solution {
    public int missingNumber(int[] nums) {
        
        // first we build without missing
        int res = 0;
        for (int i = 1; i <= nums.length; i++){
            res ^= i;
        }
        // then we see whats not
        for (int n : nums){
            res ^= n;
        }
        return res;
        
    }
}
