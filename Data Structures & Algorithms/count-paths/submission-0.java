class Solution {
    int m, n;
    int[][] dp;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;

        dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }


        return dfs(0,0);
        
    }

    private int dfs(int r, int c){
        if (
            (r < 0 || r >= m) ||
            (c < 0 || c >= n)
        ){
            return 0; // no way cause we are out of bounds
        }
        if (dp[r][c] != -1){
            return dp[r][c];
        }

        if (r == m - 1 && c == n - 1){
            return 1;
        }

        int down = dfs(r + 1, c);
        int right = dfs(r, c + 1);

        dp[r][c] = down + right;

        return dp[r][c];
    }
}
