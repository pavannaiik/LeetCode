class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k==nums.length) return nums;
        HashMap<Integer,Integer>mapCount = new HashMap<>();
        for(int i:nums) mapCount.put(i,mapCount.getOrDefault(i,0)+1);
        
        Queue<Integer>maxHeap = new PriorityQueue<>((a,b)-> mapCount.get(a)-mapCount.get(b));
        
        for(int keys: mapCount.keySet()){
            maxHeap.add(keys);
            if(maxHeap.size()>k) maxHeap.poll();
        }
        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i]=maxHeap.poll();
        }
        
        return res;
    }
}