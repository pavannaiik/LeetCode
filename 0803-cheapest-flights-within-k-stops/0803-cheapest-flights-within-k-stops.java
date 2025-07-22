class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<int[]>>map = new HashMap<>();
        for(int[] flight: flights){
            int from = flight[0], to = flight[1], price = flight[2];
            if(! map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(new int[]{to, price});
        }
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{0, src, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        while(!queue.isEmpty()){
            int[] curCity = queue.poll();
            int city = curCity[1], price = curCity[0], stops = curCity[2];
            if(stops > k) continue;
            if(!map.containsKey(city)) continue;
            for(int[] next: map.get(city)){
                int nextCity = next[0], cost = price + next[1];
                if(dist[nextCity] > cost){
                    dist[nextCity] = cost;
                    queue.add(new int[]{cost, nextCity, stops +1});
                }
            }
        }
        return  dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
        
    }
}