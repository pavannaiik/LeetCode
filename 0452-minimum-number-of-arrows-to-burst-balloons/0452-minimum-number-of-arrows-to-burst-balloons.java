class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->Integer.compare(a[0],b[0]));
        int start = points[0][0], end = points[0][1];
        int count=0;
        for(int i=1;i<points.length;i++){
            int[] point = points[i];
            if(point[0] > end){
                count++;
                start= point[0];
                end = point[1];
            }else{
                start = Math.max(start, point[0]);
                end = Math.min(end, point[1]);
            }
        }
        count++;
        return count;
    }
}