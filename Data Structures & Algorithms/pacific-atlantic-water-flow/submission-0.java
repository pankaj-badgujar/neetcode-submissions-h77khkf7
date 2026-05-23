class Solution {
    record Cell(int r, int c){}

    private void dfs(int r, int c, Set<Cell> ocean, int[][] heights, int prevHeight){
        if (
            (r < 0 || r >= heights.length) ||
            (c < 0 || c >= heights[0].length) ||
            (ocean.contains(new Cell(r, c))) ||
            prevHeight > heights[r][c]
        ){
            return;
        }
        ocean.add(new Cell(r, c));

        // dfs on neighbors
        dfs(r + 1, c, ocean, heights, heights[r][c]);
        dfs(r - 1, c, ocean, heights, heights[r][c]);
        dfs(r, c + 1, ocean, heights, heights[r][c]);
        dfs(r, c - 1, ocean, heights, heights[r][c]);
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int ROWS = heights.length;
        int COLS = heights[0].length;

        Set<Cell> pacific = new HashSet<>();
        Set<Cell> atlantic = new HashSet<>();

        for (int i = 0; i < COLS; i++){
            dfs(0, i, pacific, heights, heights[0][i]);
            dfs(ROWS - 1, i, atlantic, heights, heights[ROWS - 1][i]);
        }

        for (int i = 0; i < ROWS; i++){
            dfs(i, 0, pacific, heights, heights[i][0]);
            dfs(i, COLS - 1, atlantic, heights, heights[i][COLS - 1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++){
                if (
                    pacific.contains(new Cell(i,j)) &&
                    atlantic.contains(new Cell(i,j))
                ){
                    
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

}
