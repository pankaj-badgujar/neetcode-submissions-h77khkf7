class Solution {
    String s, p;
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;

        dp = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0,0);
    }

    private boolean dfs(int i, int j){
        // base case
        // if i and j are both out of bounds together, we reached the end
        if (j >= p.length()) {
            return i >= s.length();
        } 

        if (dp[i][j] != null){
            return dp[i][j];
        }
        
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // check * first
        if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
            // two choices
            // dont use the * OR use the *

            dp[i][j] = dfs(i, j + 2) || (match && dfs(i + 1, j));
            return dp[i][j];
        }
        if (match){
            dp[i][j] = dfs(i + 1, j + 1);
            return dp[i][j];
        }
        dp[i][j] = false;
        return false;
    }
}
