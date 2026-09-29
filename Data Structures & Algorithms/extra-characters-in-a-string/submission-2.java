class Solution {
    Set<String> set;
    public int minExtraChar(String s, String[] dictionary) {
        set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;

        return dfs(dp, s, 0);
        
    }
    private int dfs(int[] dp, String s, int i){
        if (dp[i] != -1) return dp[i];

        int res = 1 + dfs(dp, s, i + 1);
        for (int j = i; j < s.length(); j++){
            if (set.contains(s.substring(i, j + 1))){
                res = Math.min(res, dfs(dp, s, j + 1));
            }
        }
        dp[i] = res;
        return res;
    }
}