class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int n = heightMap.length;
        int m = heightMap[0].length;

        // Min-Heap to store cells with their heights
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];

        // Add boundary cells to the priority queue
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {heightMap[i][0], i, 0});
            pq.offer(new int[] {heightMap[i][m - 1], i, m - 1});
            vis[i][0] = true;
            vis[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) {
            pq.offer(new int[] {heightMap[0][i], 0, i});
            pq.offer(new int[] {heightMap[n - 1][i], n - 1, i});
            vis[0][i] = true;
            vis[n - 1][i] = true;
        }

        int[] dR = {0, 0, 1, -1};
        int[] dC = {1, -1, 0, 0};

        int vol = 0;
        int minHt = 0;

        // Process cells in the priority queue
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0];
            int r = cell[1];
            int c = cell[2];

            // Update the minimum height encountered so far
            minHt = Math.max(minHt, height);

            // Check all 4 neighbors
            for (int i = 0; i < 4; i++) {
                int tR = r + dR[i];
                int tC = c + dC[i];

                if (tR >= 0 && tR < n && tC >= 0 && tC < m && !vis[tR][tC]) {
                    vis[tR][tC] = true;
                    int neighborHeight = heightMap[tR][tC];
                    // Add water trapped at this cell
                    if (neighborHeight < minHt) {
                        vol += minHt - neighborHeight;
                    }
                    // Add the neighbor cell to the queue
                    pq.offer(new int[] {Math.max(neighborHeight, minHt), tR, tC});
                }
            }
        }

        return vol;
    }
}
