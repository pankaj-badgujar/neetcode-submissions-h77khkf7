class Solution {
    String s;
    String t;

    int[][] dp;

    public int numDistinct(String s, String t) {
        if (s.length() < t.length()){
            return 0;
        }

        this.s = s;
        this.t = t;

        dp = new int[s.length()][t.length()];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return dfs(0, 0);
    }

    // i goes through s
    // j goes through t
    private int dfs(int i, int j){

        // base case
        if (j >= t.length()){
            // we completed matching all chars of t, meaning we have 1 way
            return 1;
        }

        if (i >= s.length()){
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        int cs = s.charAt(i);
        int ct = t.charAt(j);

        if (cs != ct){
            dp[i][j] = dfs(i + 1, j);
            return dp[i][j];
        }

        // if they match, we have a choice to make
        // either we start path from here
        // or we continue checking for other such cs ahead

        dp[i][j] = dfs(i + 1, j + 1) + dfs(i + 1, j);
        return dp[i][j];
    }
}
