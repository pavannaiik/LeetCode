class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0)=='0') return 0;
        int dp1 = 1;
        int dp2 = 1;
        for(int i=2;i<=n;i++){
            int prev = s.charAt(i-2)-'0';
            int curNum = s.charAt(i-1)-'0';
            int dp = 0;
            if (curNum != 0) {
                dp += dp1;
            }
            if(prev == 1 && curNum <= 9  || prev == 2 && curNum <=6){
                dp += dp2;
            }
            dp2 = dp1;
            dp1 = dp;
            
        }
        return dp1;
    }
}