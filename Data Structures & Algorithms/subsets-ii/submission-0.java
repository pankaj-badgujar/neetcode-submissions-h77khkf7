class Solution {
    List<List<Integer>> res = new ArrayList<>();

    private void dfs(int[] nums, int i, List<Integer> subset){
        
        if (i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        // take i
        subset.add(nums[i]);
        dfs(nums, i + 1, subset);

        // skip i
        subset.remove(subset.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]){
            i++;
        }
        dfs(nums, i + 1, subset);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        dfs(nums, 0, new ArrayList<>());
        return res;
        
    }
}
