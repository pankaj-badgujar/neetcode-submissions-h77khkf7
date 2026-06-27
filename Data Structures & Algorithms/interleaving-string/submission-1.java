class Solution {
    String s1, s2, s3;
    Map<String, Boolean> dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()){
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        dp = new HashMap<>();

        return dfs(0,0,0);
    }

    private boolean dfs(int i, int j, int k){
        if (k >= s3.length()){
            // we completed all chars of s3
            return true;
        }
        
        char c1 = i < s1.length() ? s1.charAt(i) : '#';
        char c2 = j < s2.length() ? s2.charAt(j) : '#';
        char c3 = s3.charAt(k);

        String key = i + "_" + j;
        if (dp.containsKey(key)){
            return dp.get(key);
        }

        if (c3 == c1 && c3 == c2){
            dp.put(key, dfs(i + 1, j, k + 1) || dfs(i, j + 1, k + 1));
        } else if (c3 == c1){
            dp.put(key, dfs(i + 1, j, k + 1));
        } else if (c3 == c2){
            dp.put(key, dfs(i, j + 1, k + 1));
        } else {
            dp.put(key, false);
        }
        return dp.get(key);
    }
}
