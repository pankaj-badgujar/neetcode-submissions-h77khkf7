class Solution {
    List<List<Integer>> res = new ArrayList<>();

    private void dfs(List<Integer> subset, int total, int i, int[] nums, int target){
        if (total == target){
            res.add(new ArrayList<>(subset));
            return;
        }

        if (i >= nums.length || total > target){
            return;
        }

        // we include this value
        subset.add(nums[i]);
        dfs(subset, total + nums[i], i, nums, target);

        // remove the element now, total doesnt change,
        subset.remove(subset.size() - 1);
        dfs(subset, total, i + 1, nums, target);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        dfs(new ArrayList<Integer>(), 0, 0, nums, target);
        return res;
    }
}
