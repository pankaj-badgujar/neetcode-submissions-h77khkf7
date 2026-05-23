class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int fruits = 0;
        

        // first lets add all rotten fruits in q
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 0){
                    continue;
                }
                fruits++;

                if (grid[i][j] == 2){
                    q.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        if (fruits == 0) return 0;

        int minute = -1;
        int rotted = 0;

        boolean firstRots = true;

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int[] cell = q.removeFirst();
                int r = cell[0];
                int c = cell[1];

                grid[r][c] = 2; // rot it
                rotted++;


                // add eligible neighbours
                addNeighbor(r + 1, c, grid, q, visited);
                addNeighbor(r - 1, c, grid, q, visited);
                addNeighbor(r, c + 1, grid, q, visited);
                addNeighbor(r, c - 1, grid, q, visited);
            }
            
            minute++;
        }  
        
        return fruits == rotted ? minute : -1;
    }

    private void addNeighbor(int r, int c, int[][] grid, Deque<int[]> q, boolean[][] visited){
        if (
            (r < 0 || r >= grid.length ) ||
            (c < 0 || c >= grid[r].length ) ||
            (grid[r][c] != 1 ) ||
            visited[r][c]
        ) {
            return;
        }
        q.addLast(new int[]{ r, c});
        visited[r][c] = true;
    }
}
