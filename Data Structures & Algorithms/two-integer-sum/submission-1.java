class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // store complement as the key, and current index as its val 
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];

            if (map.containsKey(num)){
                return new int[]{map.get(num), i};
            }
            map.put(target - num, i);
        }
        return new int[]{};
    }
}
