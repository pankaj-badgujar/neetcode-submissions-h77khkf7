class Solution {
    public int majorityElement(int[] nums) {

        int count = 1;
        int res = nums[0];

        for (int i = 1; i < nums.length; i++){
            if (nums[i] != res){
                if (count == 0){
                    res = nums[i];
                    count++;
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }
        return res;
        
    }
}