class Solution {
    private Set visited = new HashSet<Pair<Integer, Integer>>();

    private boolean dfs(char[][] board, int i, int j, String word, int idx){
        if (idx == word.length()){
            return true;
        }

        // if i have reached an out of bound cell, then just return false
        Pair pair = new Pair(i, j);
        if (
            i < 0 || i >= board.length ||
            j < 0 || j >= board[i].length ||
            word.charAt(idx) != board[i][j] ||
            visited.contains(pair)
        ){
            return false;
        }

        visited.add(pair);

        boolean res = dfs(board, i - 1, j, word, idx + 1) ||
        dfs(board, i + 1, j, word, idx + 1) ||
        dfs(board, i, j - 1, word, idx + 1) ||
        dfs(board, i, j + 1, word, idx + 1);

        visited.remove(pair);
        return res;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0 ; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){

                if(dfs(board, i, j, word, 0)){
                    return true;
                }
            }
        }
// O(m * n * 4 ^ n where n is the length of word)
// O(dfs) = 4 ^ n where n is the length of word
        return false;
    }
}
