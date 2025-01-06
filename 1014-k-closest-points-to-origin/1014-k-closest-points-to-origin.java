class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point>pq=new PriorityQueue<>((a,b)->Double.compare(b.dist,a.dist));
        for(int[] point:points){
            int x = point[0], y=point[1];
            double dist = Math.sqrt(x*x + y*y);
            pq.add(new Point(x,y,dist));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            ans[i][0]=p.x;
            ans[i++][1]=p.y;
        }
        return ans;

    }
}
class Point{
    int x,y;
    double dist;
    Point(int x, int y, double dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}