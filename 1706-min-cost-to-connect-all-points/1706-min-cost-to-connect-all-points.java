class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        boolean[] isMST = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0, 0});

        int cost = 0;
        int count = 0;

        while(!pq.isEmpty() && count < n){
            int[] curNode = pq.poll();
            int u = curNode[0], curCost = curNode[1];
            if(isMST[u]) continue;
            isMST[u] = true;
            count++;
            cost += curCost;
            for(int v = 0;v < n;v++){
                int distance = Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1] - points[v][1]);
                if(dist[v] >  distance){
                    dist[v]=  distance;
                    pq.offer(new int[]{v, dist[v]});
                }
            }

        }
        return cost;

    }
}