class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int t = grid[0][0];
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [weight, i, j]
        minHeap.offer(new int[]{t, 0, 0});

        boolean[][] visited = new boolean[ROWS][COLS];

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.isEmpty()){
            int[] entry = minHeap.poll();

            int weight = entry[0];
            int r = entry[1];
            int c = entry[2];

            if (r == ROWS - 1 && c == COLS - 1){
                return weight;
            }

            visited[r][c] = true;

            // add neighbor
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // dont add if nei is out of bounds or visited
                if (
                    (nr < 0 || nr >= ROWS) ||
                    (nc < 0 || nc >= COLS) ||
                    visited[nr][nc]
                ) {
                    continue;
                }

                minHeap.add(new int[]{Math.max(weight, grid[nr][nc]), nr, nc});
            }
        }
        
        return -1;
    }
}
