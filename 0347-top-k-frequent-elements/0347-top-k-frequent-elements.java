class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer>freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->freqMap.get(a)-freqMap.get(b));
        for(int num:freqMap.keySet()){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            result[i++]=pq.poll();
        }
        return result;
    }
}