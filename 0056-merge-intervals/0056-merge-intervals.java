class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]>res = new ArrayList();
        int[] cur = intervals[0];
        for(int[] interval : intervals){
            if(interval[0]<=cur[1]){
                cur[1]=Math.max(cur[1],interval[1]);
            }else{
                res.add(cur);
                cur = interval;
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }
}