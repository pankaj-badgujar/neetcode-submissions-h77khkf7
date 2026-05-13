class Solution {

    List<List<Integer>> res = new ArrayList<>();

    private void dfs(int[] candidates, int i, int total, List<Integer> subset, int target){
        if (total == target){
            // that means we have found a subset that sums to target
            res.add(new ArrayList<>(subset));
            return;
        }

        if (total > target || i >= candidates.length){
            return;
        }
        int n = candidates[i];

        // include element at index i
        subset.add(n); // for each add
        dfs(candidates, i+1, total + n, subset, target);

        subset.remove(subset.size() - 1); // there is remove

        // skip element at index i
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }
        dfs(candidates, i + 1, total, subset, target);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, new ArrayList<>(), target);
        return res;

        
    }
}
