class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans =0;
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.offer(num);
        }
        while(k>0){
            int cur = pq.poll();
            ans += cur;
            pq.add((int)Math.ceil((double) (cur)/3));
            k--;
        }
        return ans;
    }
}