class Solution {
    public long numberOfWays(String s) {
        long ans =0;
        int n = s.length();
        long totalZeros = 0;
        long totalOnes =0;
        for(char c:s.toCharArray()){
            totalZeros += c=='0'?1:0;
        }
        totalOnes = n-totalZeros;
        long curZeros =0, curOnes =0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                ans += (curOnes * (totalOnes-curOnes));
                curZeros++;
            }else{
                ans += (curZeros * (totalZeros-curZeros));
                curOnes++;
            }
        }
        return ans;
    }
}