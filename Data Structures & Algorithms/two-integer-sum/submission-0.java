class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            
            // if it has, we have found the partner's index and it must be lesser
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            // else if map does not have the key, put it as its complement, vs its index
            else{
                map.put(target - nums[i], i);
            }
        }
        return new int[0];
    }
}