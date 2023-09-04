class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s!=null && n!=0 && s.charAt(0)=='0') return 0;
        int twoback =1;
        int oneback = s.charAt(0)=='0'?0:1;
        for(int i=2;i<n+1;i++){
            int current = s.charAt(i-1)=='0'?0:oneback;
            if(s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)- '0' < 7){
                current += twoback;
            }
            twoback = oneback;
            oneback = current;
        }
       return oneback;
    }
}