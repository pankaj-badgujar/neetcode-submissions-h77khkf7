class Solution {
    private void dfs(char[][] board, int r, int c, boolean[][] visited){
        // handle out of bounds
        if (
            (r < 0 || r >= board.length) ||
            (c < 0 || c >= board[r].length) ||
            (board[r][c] == 'X') ||
            (visited[r][c])
        ){
            return;
        }
        board[r][c] = '#';
        visited[r][c] = true;

        dfs(board, r + 1, c, visited);
        dfs(board, r - 1, c, visited);
        dfs(board, r, c + 1, visited);
        dfs(board, r, c - 1, visited);
    }

    public void solve(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++){
            if (board[0][c] == 'O'){
                System.out.println(0 + ", " +c );
                dfs(board, 0, c, visited);
            }
            if (board[ROWS - 1][c] == 'O'){
                System.out.println(ROWS - 1 + ", " +c );
                dfs(board, ROWS - 1, c, visited);
            }
        }
        for (int r = 0; r < ROWS; r++){
            if (board[r][0] == 'O'){
                System.out.println(r + ", 0" );
                dfs(board, r, 0, visited);
            }
            if (board[r][COLS - 1] == 'O'){
                System.out.println(r + ", " + (COLS - 1));
                dfs(board, r, COLS - 1, visited);
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
