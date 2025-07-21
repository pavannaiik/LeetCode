class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
		for(int[] time: times){
			int u = time[0], v = time[1], w = time[2];
			if(!map.containsKey(u)){
				map.put(u, new ArrayList<>());
			}
			map.get(u).add(new int[]{v, w});
		}
		int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0], time = cur[1];
            if(!map.containsKey(node)) continue;
            for(int[] neighbor: map.get(node)){
                int next = neighbor[0], weight = neighbor[1];
                if(dist[next] > weight +time){
                    dist[next] = weight + time;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
		return ans;
		
    }
}