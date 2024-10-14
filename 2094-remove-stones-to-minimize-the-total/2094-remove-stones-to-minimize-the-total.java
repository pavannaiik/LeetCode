class Solution {
    public int minStoneSum(int[] piles, int k) {
        int total =Arrays.stream(piles).sum();
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)-> (int) Math.floor((double)b/2)-(int)Math.floor((double) a/2));
        for(int pile:piles){
            pq.offer(pile);
        }
        int removed =0;
        while(k-->0){
            int cur = pq.poll();
            int remaining = (int) Math.floor((double)cur/2);

            removed += remaining;
            pq.offer(cur - remaining);
        }
        return total-removed;

    }
}