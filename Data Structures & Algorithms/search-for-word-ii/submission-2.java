class TreeNode {
    Map<Character, TreeNode> children = new HashMap<>();
    boolean endOfWord = false;

    private void addWord(String word){
        TreeNode curr = this;
        for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                curr.children.putIfAbsent(c, new TreeNode());
                curr = curr.children.get(c);
            }
        curr.endOfWord = true;
    }

}

class Solution {

    private boolean[][] visited;
    private Set<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        TreeNode root = new TreeNode();
        
        // create a prefix tree
        for (String word : words){
            root.addWord(word);
        }

        int rows = board.length, cols = board[0].length;
        result = new HashSet<>();
        visited = new boolean[rows][cols];

        for (int i = 0 ; i < rows; i++){
            for (int j = 0; j < cols; j++){
                dfs(board, i, j, root, "");
            }
        }

        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, int row, int col, TreeNode node, String word){
        int rows = board.length;
        int cols = board[0].length;

        if (row < 0 || col < 0 ||
            row >= rows || col >= cols ||
            visited[row][col] ||
            !node.children.containsKey(board[row][col])
         ){
            return;
        }
        
        visited[row][col] = true;
        TreeNode childNode = node.children.get(board[row][col]);
        word += board[row][col];
        

        if (childNode.endOfWord){
            // we add it to result
            result.add(word);
        }

        // check its neighbour in childnodes
        dfs(board, row + 1, col, childNode, word);
        dfs(board, row - 1, col, childNode, word);
        dfs(board, row, col + 1, childNode, word);
        dfs(board, row, col - 1, childNode, word);
        
        visited[row][col] = false;
    }


    
}
