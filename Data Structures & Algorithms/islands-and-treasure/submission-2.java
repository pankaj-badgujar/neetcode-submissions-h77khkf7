class Solution {
    record Cell(int r, int c) {}

    public void islandsAndTreasure(int[][] grid) {

        Set<Cell> visited = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 0){
                    queue.addLast(new int[]{i, j});
                    visited.add(new Cell(i, j));
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] cell = queue.removeFirst();
                int row = cell[0];
                int col = cell[1];

                grid[row][col] = dist;

                addToQueue(row + 1, col, queue, visited, grid);
                addToQueue(row - 1, col, queue, visited, grid);
                addToQueue(row, col + 1, queue, visited, grid);
                addToQueue(row, col - 1, queue, visited, grid);
            }

            dist++;
        }        
    }
    private void addToQueue(int r, int c, Deque<int[]> queue, Set<Cell> visited, int[][] grid){
        if (
            (r < 0 || r >= grid.length) ||
            (c < 0 || c >= grid[r].length) ||
            visited.contains(new Cell(r, c)) ||
            grid[r][c] == -1
        ){
            return;
        }
        queue.addLast(new int[]{r ,c});
        visited.add(new Cell(r, c));
    }
}
