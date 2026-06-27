class Solution {


    public int numDistinct(String s, String t) {
        if (s.length() < t.length()){
            return 0;
        }
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int k = 0; k <= s.length(); k++){
            dp[k][t.length()] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = t.length() - 1; j >= 0; j--){
                if (s.charAt(i) == t.charAt(j)){
                    dp[i][j] += dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] += dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
