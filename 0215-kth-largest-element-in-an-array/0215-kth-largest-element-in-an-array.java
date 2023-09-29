class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int n:nums){
            pq.offer(n);
        }
        while(k-->1){
            pq.poll();
        }
        return pq.peek();
    }
}