class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int minGroups = 0;
        for(int[] interval:intervals){
            int start =interval[0];
            int end = interval[1];
            while(!pq.isEmpty() && pq.peek() < start){
                pq.poll();
            }
            pq.add(end);
            minGroups = Math.max(minGroups, pq.size());
        }
        return minGroups;
       
    }
}