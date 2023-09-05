class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>res = new ArrayList();
        for(int[] arr : intervals){
            if(newInterval[1]<arr[0]){
                res.add(newInterval);
                newInterval = arr;
            }else if(arr[1] < newInterval[0]){
                res.add(arr);
            }else{
                newInterval[0]=Math.min(newInterval[0],arr[0]);
                newInterval[1]=Math.max(newInterval[1],arr[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}