class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0)=='0') return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int prev = s.charAt(i-2)-'0';
            int curNum = s.charAt(i-1)-'0';
            if (curNum != 0) {
                dp[i] += dp[i - 1];
            }
            if(prev == 1 && curNum <= 9  || prev == 2 && curNum <=6){
                dp[i] += dp[i-2];
            }
            
        }
        return dp[n];
    }
}