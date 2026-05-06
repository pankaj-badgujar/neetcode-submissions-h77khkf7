class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>(); 

    private void dfs(int i, int[] nums){
        if (i >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        // include nums[i]
        subset.add(nums[i]);
        dfs(i + 1, nums);

        // not include nums[i]
        subset.remove(subset.size() - 1);
        dfs(i + 1, nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1){
            return result;
        }

        dfs(0, nums);
        return result;
    }
}
