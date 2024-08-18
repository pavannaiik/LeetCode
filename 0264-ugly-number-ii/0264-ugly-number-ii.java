class Solution {
    public int nthUglyNumber(int n) {
        int index2=0, index3=0,index5=0;
        int multiple2=2;
        int multiple3=3;
        int multiple5=5;
        int[] dp = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int nextUglyNumber = Math.min(multiple2,Math.min(multiple3,multiple5));
            dp[i]=nextUglyNumber;
            if(nextUglyNumber==multiple2){
                index2++;
                multiple2 = dp[index2]*2;

            }
            if(nextUglyNumber==multiple3){
                index3++;
                multiple3 = dp[index3]*3;
            }
            if(nextUglyNumber==multiple5){
                index5++;
                multiple5 = dp[index5]*5;
            }
        }
        return dp[n-1];

    }
}