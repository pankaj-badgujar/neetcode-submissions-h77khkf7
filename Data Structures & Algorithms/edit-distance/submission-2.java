class Solution {
    
    public int minDistance(String word1, String word2) {
        int m = word1.length(); // 3
        int n = word2.length(); // 3

        int[][] dp = new int[m + 1][n + 1];

        // fill last row of each col with n - j
        for (int j = 0; j <= n; j++){
            dp[m][j] = n - j;
        }
        // fill last col of each row with m - i
        for (int i = 0; i <= m; i++){
            dp[i][n] = m - i;
        }

        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // 3 operations
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i + 1][j + 1]);
                }

            }
        }

        return dp[0][0];
    }
}
