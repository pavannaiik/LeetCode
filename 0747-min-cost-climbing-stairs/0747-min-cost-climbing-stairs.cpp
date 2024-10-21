class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int a =0, b=0;
        int n=cost.size();
        for(int i=2;i<=n;i++){
            int t= a;
            a = min(a+cost[i-1], b+cost[i-2]);
            b=t;
        }
        return a;
    }
};