class Solution {
    public int findDuplicate(int[] nums) {
        // [4,2,3,1,4]
        // [4,2,3,-1,4]
        // [4,-2,3,-1,4]
        // [4,-2,-3,-1,4]
        // [-4,-2,-3,-1,4]
        // [-4,-2,-3,-1,4]

        for(int i = 0; i < nums.length; i++){
            int newIndex = Math.abs(nums[i]) - 1;
            
            if(nums[newIndex] < 0){
                return Math.abs(nums[i]);
            }
            nums[newIndex] *= -1;
        }
        return -1;
    }
}
