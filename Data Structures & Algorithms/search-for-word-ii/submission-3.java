class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }

    public void addWord(String word){
        TrieNode curr = this;

        for (char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }
}

class Solution {
    boolean[][] visiting;
    Set<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        res = new HashSet<>();

        for (String word : words){
            root.addWord(word);
        }

        int ROWS = board.length;
        int COLS = board[0].length;
        visiting = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(res);
        
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, String word){
        if (
            (r < 0 || r >= board.length) ||
            (c < 0 || c >= board[0].length) ||
            (c < 0 || c >= board[0].length) ||
            visiting[r][c] ||
            !parent.children.containsKey(board[r][c])
        ) return;

        TrieNode child = parent.children.get(board[r][c]);
        visiting[r][c] = true;

        word += board[r][c];

        if (child.endOfWord){
            res.add(word);
        }

        dfs(board, r - 1, c, child, word);
        dfs(board, r + 1, c, child, word);
        dfs(board, r, c - 1, child, word);
        dfs(board, r, c + 1, child, word);

        visiting[r][c] = false;
    }
}








