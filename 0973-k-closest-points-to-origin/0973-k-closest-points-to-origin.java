class Solution {
    class Point{
        int x;
        int y;
        Double dist;
        Point(int x, int y,double dist){
            this.x=x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<Point>pq = new PriorityQueue<Point>(new Comparator<Point>(){
           @Override
           public int compare(Point p1, Point p2){
               return Double.compare(p1.dist, p2.dist);
           }
       });
        for(int[] point: points){
            Double dfo = Math.sqrt(point[0]*point[0]+point[1]*point[1]);
            pq.add(new Point(point[0],point[1],dfo));
        }
        int[][] ans = new int[k][2];
        int i=0;
        while(k!=0){
           Point p = pq.poll();
            ans[i][0]= p.x;
            ans[i][1]=p.y;
            k--;
            i++;
        }
        return ans;
    }
}