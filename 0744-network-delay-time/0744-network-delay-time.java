class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int[] time: times){
            if(!map.containsKey(time[0])){
                map.put(time[0], new ArrayList<>());
            }
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        distance[k]=0;
        pq.add(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] curNode = pq.poll();
            int node = curNode[0], time = curNode[1];
            if(!map.containsKey(node)) continue;
            for(int[] neighbor: map.get(node)){
                int next = neighbor[0], weight = neighbor[1];
                if(distance[next] > time + weight){
                    distance[next]= time+weight;
                    pq.add(new int[]{next, distance[next]});
                }
            }
        }
        int minTime = 0;
        for(int i=1;i<=n;i++){
            if(distance[i]== Integer.MAX_VALUE) return -1;
            minTime = Math.max(minTime, distance[i]);
        }
        return minTime;

    }
}