class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, left = 0, right = n - 1, bottom = m - 1;
         
        List<Integer> res = new ArrayList<>();

        while (top <= bottom && left <= right){
            // we go right
            for (int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            if (res.size() == (m * n)) break;
            // now we go bottom
            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;

            if (res.size() == (m * n)) break;
            // now we go left
            for(int i = right; i >= left ; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;

            if (res.size() == (m * n)) break;
            // now we go up
            for(int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
            }
            left++;

            if (res.size() == (m * n)) break;
        }

        return res;
    }
}
