class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 1;
        for(int i = 0; i<intervals.length; i++){
                while(!pq.isEmpty() && pq.peek()<=intervals[i][0]){
                pq.poll();
            }
            pq.offer(intervals[i][1]);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}