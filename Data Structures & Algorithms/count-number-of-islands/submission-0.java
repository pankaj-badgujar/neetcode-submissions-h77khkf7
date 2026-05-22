class Solution {

    private char[][] grid;

    private void dfs(int r, int c){
        // handle out of bounds
        if (
            (r < 0 || r >= grid.length) ||
            (c < 0 || c >= grid[r].length) ||
            grid[r][c] != '1'
        ){
            return;
        }
        grid[r][c] = '#'; // mark it visited

        //do dfs for surrounding
        dfs(r - 1, c);
        dfs(r + 1, c);
        dfs(r, c - 1);
        dfs(r, c + 1);
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int count = 0;

        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[r].length; c++ ){
                if (this.grid[r][c] == '1'){
                    dfs(r,c);
                    count++;
                }
            }
        }
        return count;
    }
}
