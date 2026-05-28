class Solution {
    private void dfs(char[][] board, int r, int c){
        // handle out of bounds
        if (
            (r < 0 || r >= board.length) ||
            (c < 0 || c >= board[r].length) ||
            (board[r][c] != 'O')
        ){
            return;
        }
        board[r][c] = '#';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;

        for (int c = 0; c < COLS; c++){
            if (board[0][c] == 'O'){
                dfs(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O'){
                dfs(board, ROWS - 1, c);
            }
        }
        for (int r = 0; r < ROWS; r++){
            if (board[r][0] == 'O'){
                dfs(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O'){
                dfs(board, r, COLS - 1);
            }
        }

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                if (board[r][c] == '#'){
                    board[r][c] = 'O';
                }
            }
        }
    }
}
