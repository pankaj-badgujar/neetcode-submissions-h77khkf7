class Solution {
    String s, p;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;

        return dfs(0,0);
    }

    private boolean dfs(int i, int j){
        // base case
        // if i and j are both out of bounds together, we reached the end
        if (i >= s.length() && j >= p.length()) return true;
        if (j >= p.length()) return false;

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // check * first
        if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
            // two choices

            return dfs(i, j + 2) || (match && dfs(i + 1, j));
        }
        if (match){
            return dfs(i + 1, j + 1);
        }
        return false;
    }
}
