class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int n = rooms.length, m = rooms[0].length;

        // Add all gates to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : directions) {
                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];

                // Check bounds and update distance if it's an empty room
                if (r >= 0 && r < n && c >= 0 && c < m && rooms[r][c] == Integer.MAX_VALUE) {
                    rooms[r][c] = rooms[cell[0]][cell[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
    }
}
