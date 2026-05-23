class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        int minute = 0;
        

        // first lets add all rotten fruits in q
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1){
                    fresh++;
                }

                if (grid[i][j] == 2){
                    q.addLast(new int[]{i, j});
                }
            }
        }


        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty() && fresh > 0){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cell = q.removeFirst();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (
                        (row < 0 || row >= grid.length ) ||
                        (col < 0 || col >= grid[row].length ) ||
                        (grid[row][col] != 1 )
                    ) {
                        continue;
                    }
                    grid[row][col] = 2; // rot it
                    q.addLast(new int[]{ row, col});
                    fresh--;
                    }
                }
            minute++;
        }  
        
        return fresh > 0 ? -1 : minute;
    }

    private void addNeighbor(int r, int c, int[][] grid, Deque<int[]> q){
        
    }
}
