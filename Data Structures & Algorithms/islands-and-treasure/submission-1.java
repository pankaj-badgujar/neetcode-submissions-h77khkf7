class Solution {

    // find treasure chest and then start  dfs
    // count route val at each depth
    // start putting land cells as math.min(its current, route val)
    // once we end, we will have the res
    public void islandsAndTreasure(int[][] grid) {

        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[r].length; c++){
                if (grid[r][c] == 0) {
                    dfs(grid, r, c, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int r, int c, int distance){
        // handle out of bounds + invalid
        if(
            (r < 0 || r >= grid.length) ||
            (c < 0 || c >= grid[r].length) ||
            (grid[r][c] < 0) ||
            distance > grid[r][c]
        ){
            return;
        }
        grid[r][c] = Math.min(grid[r][c], distance);

        dfs(grid, r - 1, c, distance + 1);
        dfs(grid, r + 1, c, distance + 1);
        dfs(grid, r, c - 1, distance + 1);
        dfs(grid, r, c + 1, distance + 1);
    }
}
