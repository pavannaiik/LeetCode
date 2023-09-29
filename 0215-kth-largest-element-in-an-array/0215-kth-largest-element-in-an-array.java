class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
        for(int n:nums){
            if(pq.size()>=k &&  n>pq.peek()) pq.poll();
            if(pq.size()<k)
            pq.offer(n);
        }
        return pq.peek();
    }
}