class Solution {
    public void setZeroes(int[][] matrix) {

        boolean topRow = false;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){

                if (matrix[i][j] == 0){
                    // mark col as 0
                    matrix[0][j] = 0;
                    // mark row as 0 but check if its top row or not
                    if (i == 0){
                        topRow = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        // now next iteration where we look up and we mark
        for (int i = 1; i < matrix.length; i++){
                // for each position, check if its main col or main row says its 0
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[0][j] == 0 || (i == 0 && topRow) || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0){
            for (int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if (topRow){
            for (int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

    }
}
