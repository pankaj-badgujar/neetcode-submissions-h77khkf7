class Solution {
    
    List<List<Integer>> res = new ArrayList<>();

    private void dfs(int target, int[] nums, List<Integer> subset) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) break; // sorted, so no point continuing

            subset.add(nums[i]);

            if (nums[i] == target) {
                res.add(new ArrayList<>(subset));
            } else {
                int[] newArray = new int[nums.length - i];
                System.arraycopy(nums, i, newArray, 0, nums.length - i);
                dfs(target - nums[i], newArray, subset);
            }

            subset.remove(subset.size() - 1); // always clean up
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(target, nums, new ArrayList<>());

        return res;
    }
}
