class Solution {
    public int kBigIndices(int[] nums, int k) {
        int count =0;
        int len = nums.length;
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        boolean[] left = new boolean[len];
        
        for(int i=0;i<len;i++){
            if(pq.size()==k && pq.peek() < nums[i]){
                left[i]=true;
            }
            pq.offer(nums[i]);
            if(pq.size() >k){
                pq.poll();
            }
        }
        pq.clear();
        for(int i=len-1;i>=0;i--){
             if(pq.size()==k && pq.peek() < nums[i] && left[i]){
                count++;
            }
             pq.offer(nums[i]);
            if(pq.size() >k){
                pq.poll();
            }
        }
        return count;
    }
}