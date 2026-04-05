class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        // first we go through columns
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != '.'){
                    boolean addSuccess = set.add(board[i][j]);
                    if(!addSuccess){
                        return false;
                    }
                }
            }
            set.clear();
        }
        set.clear();
        // then we go through columns
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    boolean addSuccess = set.add(board[j][i]);
                    if(!addSuccess){
                        return false;
                    }
                }
            }
            set.clear();
        }
        set.clear();
        for(int bigI = 0; bigI < 9; bigI += 3){
            for(int bigJ = 0; bigJ < 9; bigJ += 3){
                // System.out.println(bigI +"-,-" + bigJ);

                for(int i = bigI; i < bigI + 3; i++){
                    for(int j = bigJ; j < bigJ + 3; j++){
                        // System.out.println(i +"," + j +" = " + board[i][j]);
                         if(board[i][j] != '.'){
                            boolean addSuccess = set.add(board[i][j]);
                            if(!addSuccess){
                                return false;
                            }
                         }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
