class Solution {

    private int bfs(int[][] grid, int r, int c){
        int area = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{r, c});

        while(!queue.isEmpty()){
            int[] cell = queue.removeFirst();
            int cellR = cell[0];
            int cellC = cell[1];

            // handle out of bounds
            if (
                (cellR < 0 || cellR >= grid.length) ||
                (cellC < 0 || cellC >= grid[cellR].length) ||
                grid[cellR][cellC] == 0
            ){
                continue;
            }
            area++;
            grid[cellR][cellC] = 0; // mark visited
            // add neighbours to queue
            queue.add(new int[]{cellR - 1, cellC});
            queue.add(new int[]{cellR + 1, cellC});
            queue.add(new int[]{cellR, cellC - 1});
            queue.add(new int[]{cellR, cellC + 1});
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;

        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c < grid[r].length; c++){
                if (grid[r][c] == 1){
                    maxArea = Math.max(maxArea, bfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }
}
