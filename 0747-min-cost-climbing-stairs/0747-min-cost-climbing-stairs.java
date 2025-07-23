class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a =0,b=0;
        for(int i=2;i<=cost.length;i++){
            int t = a;
            a = Math.min(a+cost[i-1],b+cost[i-2]);
            b=t;
        }
        return a;
    }
}