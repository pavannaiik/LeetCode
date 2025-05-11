class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int s : stones)
            pq.add(s);
        while(pq.size()>=2){
            int y = pq.poll();
            int x = pq.poll();
            if(y>x){
                pq.add(y-x);
            }
        }
        return pq.peek()!=null?pq.peek():0;
    }
}