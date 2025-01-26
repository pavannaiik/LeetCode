class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for(int[] interval:intervals){
            if(interval[0] > end){
                list.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }else{
                if(interval[1] < start){
                    list.add(interval);
                }else {
                    start = Math.min(start, interval[0]);
                     end = Math.max(end,interval[1]);
                    }
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);
    }
}