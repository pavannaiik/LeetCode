class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer>countMap = new HashMap<>();
        for(int num:nums){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->countMap.get(a)-countMap.get(b));
        for(int key: countMap.keySet()){
            if(pq.size() >k){
                pq.poll();
            }
            pq.add(key);
        }
        if(pq.size() >k){
                pq.poll();
            }
        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll();
        }
        return ans;

    }
}