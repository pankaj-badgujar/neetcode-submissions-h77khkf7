class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int maxRows = triangle.size();
        List<Integer> prev = triangle.get(triangle.size() - 1);

        for (int i = maxRows - 2; i >= 0; i--){
            List<Integer> curr = triangle.get(i);

            for (int j = i; j >= 0; j--){
                int newValue = curr.get(j) + Math.min(prev.get(j),prev.get(j + 1));
                curr.set(j, newValue);
            }
            prev = curr;
        }
        return prev.get(0);
    }
}