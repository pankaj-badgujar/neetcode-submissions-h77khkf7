class Solution {
    String text1;
    String text2;
    int[][] dp;
    
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;

        dp = new int[text1.length()][text2.length()];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return dfs(0,0);
        
    }

    private int dfs(int i, int j){
        if (i >= text1.length() || j >= text2.length()){
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        char c1 = text1.charAt(i);
        char c2 = text2.charAt(j);

        if (c1 == c2){
            return 1 + dfs(i + 1, j + 1);
        }

        dp[i][j] = Math.max(dfs(i + 1, j), dfs(i, j + 1));
        return dp[i][j];
    }
}
