class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        boolean rowFound = false;
        // calculate mid of row counts
        int l = 0, r = matrix.length - 1;

        while(l <= r){
            int m = (l + r)/2;
            System.out.printf("l: %d, r: %d, m: %d\n", l,r,m);

            if (target > matrix[m][cols - 1]){
                l = m + 1;
            } else if (target < matrix[m][0]){
                r = m - 1;
            } else {
                break;
            }
        }

        if( l > r){
            return false;
        } 
        int left = 0, right = cols - 1, m = (l + r)/2;

        while(left <= right){
            int mid = (left + (right - left)/2);
            if(matrix[m][mid] < target){
                left = mid + 1;
            } else if (matrix[m][mid] > target){
                right = mid - 1;
            } else {
                return true;
            }

        }
        return false;

    }
}
