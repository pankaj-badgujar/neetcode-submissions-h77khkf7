class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        boolean rowFound = false;
        // calculate mid of row counts
        int l = 0, r = matrix.length - 1;
        int m = 0;

        while(l <= r){
            m = (l + r)/2;
            System.out.printf("l: %d, r: %d, m: %d\n", l,r,m);

            if (target > matrix[m][cols - 1]){
                l = m + 1;
            } else if (target < matrix[m][0]){
                r = m - 1;
            } else if (target >= matrix[m][0] && target <= matrix[m][cols - 1] ){
                // if target is within this row, then do BS here. else we shift l and r.
                rowFound = true;
                break;
            }
        }
                System.out.println("rowFound: " + rowFound);
                System.out.println("row: " + m);

        if(rowFound){
            int left = 0, right = cols - 1;
            while(left <= right){
                int mid = (left + (right - left)/2);
                if(matrix[m][mid] < target){
                    left = mid + 1;
                } else if (matrix[m][mid] > target){
                    right = mid - 1;
                } else {
                    if(matrix[m][mid] == target){
                        return true;
                    }
                }

            }
            return false;
        }
        return false;
    }
}
