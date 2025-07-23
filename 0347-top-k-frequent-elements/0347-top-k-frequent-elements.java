class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:nums) map.put(num,map.getOrDefault(num, 0)+1);
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int key:map.keySet()) pq.add(key);
        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty() && k-- >0){
            ans[i++]=pq.poll();
        }
        return ans;
    }
}