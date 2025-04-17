class Solution {

    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        pq.add(intervals[0][1]);
        int maxCount = 1;
        for(int i = 1; i<intervals.length; i++){
            while(!pq.isEmpty() &&pq.peek()<=intervals[i][0]){
                pq.poll();
            }
            pq.add(intervals[i][1]);

            maxCount = Math.max(maxCount, pq.size());
        }
        return maxCount;
    }
}