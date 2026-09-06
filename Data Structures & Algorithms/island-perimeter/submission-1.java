class Solution {
    boolean[][] visited;
    int ROWS, COLS;

    public int islandPerimeter(int[][] grid) {
        this.ROWS = grid.length;
        this.COLS = grid[0].length;

        this.visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == 1){
                    return dfs(grid, r, c);
                    
                }
            }
        }

        return 0;

        // 1 is land, 0 is water
        // we start dfs from the node that has land
        // once we find it, we start dfs and keep adding lands
        // once done we will have total number of lands that forms an island
        // edge cases:
            // only 1 cell : p = 4
            // two or more cells: have begining and end, so 3 each for them and 2 for remaining

        
    }
    private int dfs(int[][] grid, int r, int c){
        // bounds
        if (
            (r < 0 || r >= ROWS) ||
            (c < 0 || c >= COLS) ||
            (grid[r][c] == 0)
        ){
            return 1;
        }
        if (visited[r][c]){
            return 0;
        }

        visited[r][c] = true;
        int perimeter = 0;
        
        perimeter += dfs(grid, r - 1, c);
        perimeter += dfs(grid, r + 1, c);
        perimeter += dfs(grid, r, c - 1);
        perimeter += dfs(grid, r, c + 1);

        // if i am a valid cell, i will update my own count and wont return anything
        return perimeter;
    }
}