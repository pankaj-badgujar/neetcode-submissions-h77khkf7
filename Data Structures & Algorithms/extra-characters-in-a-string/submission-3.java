class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
    void addWord(String word){
        TrieNode curr = this;
        for (char c : word.toCharArray()){
            if (curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
}
class Solution {
    
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary){
            root.addWord(word);
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;

        return dfs(dp, root, s, 0);
        
    }
    private int dfs(int[] dp, TrieNode curr, String s, int i){
        if (dp[i] != -1) return dp[i];

        int res = 1 + dfs(dp, curr, s, i + 1);

        for (int j = i; j < s.length(); j++){

            if (curr.children[s.charAt(j) - 'a'] == null) break;

            curr = curr.children[s.charAt(j) - 'a'];
            if (curr.isWord){
                res = Math.min(res, dfs(dp, curr, s, j + 1));
            }
        }
        dp[i] = res;
        return res;
    }
}