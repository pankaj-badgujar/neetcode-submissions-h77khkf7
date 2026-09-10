class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int maxRows = triangle.size();
        int[][] grid = new int[maxRows][maxRows];

        List<Integer> lastRow = triangle.get(maxRows - 1);
        for (int j = 0; j < maxRows; j++){
            grid[maxRows - 1][j] = lastRow.get(j);
        }

        System.out.println(Arrays.deepToString(grid));

        

        for (int i = maxRows - 2; i >= 0; i--){
            for (int j = i; j >= 0; j--){
                grid[i][j] = triangle.get(i).get(j) + Math.min(grid[i + 1][j], grid[i + 1][j + 1]);
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return grid[0][0];
    }
}