class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        
        int n = queries.length;
        int m = intervals.length;
        int[][] queriesWithIndex = new int[n][2];
        for(int i=0;i<n;i++) queriesWithIndex[i] = new int[]{queries[i], i};
        Arrays.sort(queriesWithIndex, (a, b)->a[0]-b[0]);
        int i=0;
        int j=0;
        int[] res = new int[n]; 
        
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        while(i <n){
            int q = queriesWithIndex[i][0], idx = queriesWithIndex[i][1];
            while ( j< m && q >= intervals[j][0]){
                int start = intervals[j][0];
                int end = intervals[j][1];
                pq.add(new int[]{end-start+1, end});
                j++;
            }
            

            while(!pq.isEmpty() && pq.peek()[1] < q){
                pq.poll();
            }
            if(!pq.isEmpty())
            res[idx]= pq.peek()[0]; else res[idx]=-1;
            i++;
        }
        return res;
    }
}