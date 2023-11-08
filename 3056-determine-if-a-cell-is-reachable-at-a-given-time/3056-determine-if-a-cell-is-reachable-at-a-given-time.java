class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx==fx && fy==sy && t==1) return false;
        int x_distance = Math.abs(sx-fx);
        int y_distance = Math.abs(sy-fy);

        return t >= Math.max(x_distance,y_distance);


    }
}