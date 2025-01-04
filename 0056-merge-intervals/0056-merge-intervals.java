class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]>mergedInterval = new ArrayList<>();
        for(int[] interval: intervals){
            if(interval[0] > end){
                mergedInterval.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }else{
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        mergedInterval.add(new int[]{start, end});
        return mergedInterval.toArray(new int[0][mergedInterval.size()]);
    }
}