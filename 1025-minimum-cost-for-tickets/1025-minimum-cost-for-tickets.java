class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int lastDayTravel = days[n-1];
        int[] dp = new int[lastDayTravel+1];
        boolean[] traveled = new boolean[lastDayTravel+1];
        for(int day:days){
            traveled[day]=true;
        }
        for(int i=1;i<=lastDayTravel;i++){
            if(!traveled[i]){
                dp[i]=dp[i-1];
            }else{
                dp[i]=dp[i-1]+costs[0];
                dp[i]=Math.min(dp[i], (i>=7?dp[i-7]:0)+costs[1]);
                dp[i]=Math.min(dp[i], (i>=30?dp[i-30]:0)+costs[2]);
            }
        }
        return dp[lastDayTravel];
    }
}