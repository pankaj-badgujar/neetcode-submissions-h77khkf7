class Solution {
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> posDiagSet = new HashSet<>(); // r + c 
    Set<Integer> negDiagSet = new HashSet<>(); // r - c

    private List<List<String>> res = new ArrayList<>();

    public void backtrack(int r, char[][] board, int n){
        if (r == n){
            // means we have placed all queens
            List<String> solution = new ArrayList<>();

            for (char[] row : board){
                solution.add(new String(row));
            }
            res.add(solution);
            return;
        }

        for (int c = 0; c < n; c++){
            if (
                colSet.contains(c) || 
                posDiagSet.contains(r + c) ||
                negDiagSet.contains(r - c)
            ){
                continue;
            }

            colSet.add(c);
            posDiagSet.add(r + c);
            negDiagSet.add(r - c);
            board[r][c] = 'Q';            

            backtrack(r + 1, board, n);

            colSet.remove(c);
            posDiagSet.remove(r + c);
            negDiagSet.remove(r - c);
            board[r][c] = '.';            
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board){
            Arrays.fill(row, '.');
        }

        backtrack(0, board, n);

        return res;
    }
}
