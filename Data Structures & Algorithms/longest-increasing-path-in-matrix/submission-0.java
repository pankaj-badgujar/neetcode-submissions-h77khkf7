class Solution {
    int[][] matrix;
    int[][] dp;
    int ROWS, COLS;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;

        this.ROWS = matrix.length;
        this.COLS = matrix[0].length;

        dp = new int[ROWS][COLS];

        int longestPath = 0;

        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++){
                longestPath = Math.max(longestPath, dfs(i,j, -1));
            }
        }
        return longestPath;
    }

    private int dfs(int i, int j, int prev){
        // out of bounds check
        if (
            (i < 0 || i >= ROWS) ||
            (j < 0 || j >= COLS) ||
            matrix[i][j] <= prev
        ) {
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }
        // neighbors
        int up = dfs(i - 1, j, matrix[i][j]);
        int down = dfs(i + 1, j, matrix[i][j]);
        int left = dfs(i, j - 1, matrix[i][j]);
        int right = dfs(i, j + 1, matrix[i][j]);

        dp[i][j] = 1 + Math.max(Math.max(Math.max(left, right), up), down);

        return dp[i][j];
    }
}
