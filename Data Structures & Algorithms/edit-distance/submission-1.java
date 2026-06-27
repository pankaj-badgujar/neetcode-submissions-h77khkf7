class Solution {
    String word1, word2;
    int[][] dp;
    
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;

        dp = new int[word1.length() + 1][word2.length() + 1];

        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        dp[word1.length()][word2.length()] = 0;
        return dfs(0,0);
        
    }

    private int dfs(int i, int j){
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        
        if (j == word2.length() && i == word1.length()){
            dp[i][j] = 0; // we dont need any operations anymore
            return dp[i][j];
        }
        if (j == word2.length()){
            // if i is still remaining
            dp[i][j] =  1 + dfs(i + 1, j); // we need one operation to remove a character and then check for more
            return dp[i][j];
        }
        if (i == word1.length()){
            dp[i][j] = 1 + dfs(i, j + 1);
            return dp[i][j];
        }

        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);

        if (c1 == c2){
            dp[i][j] = dfs(i + 1, j + 1);
            return dp[i][j];
        }
        // not eq, so we have three choices here
        // add
        int minOps = dfs(i, j + 1);
        // delete
        minOps = Math.min(minOps, dfs(i+1, j));
        // replace
        minOps = Math.min(minOps, dfs(i+1, j + 1));

        dp[i][j] = 1 + minOps;

        return dp[i][j];
    }
}
