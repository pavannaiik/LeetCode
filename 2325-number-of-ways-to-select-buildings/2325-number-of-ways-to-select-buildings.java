class Solution {
    public long numberOfWays(String s) {
        long ans =0;
        int n = s.length();
        long[] leftZeros = new long[n];
        long[] rightZeros = new long[n];
        long[] leftOnes = new long[n];
        long[] rightOnes = new long[n];
        long one=0, zero=0;
        for(int i=0;i<n;i++){
            leftZeros[i] = zero;
            leftOnes[i] = one;
            if(s.charAt(i)=='0'){
                zero++;
            }else{
                one++;
            }
            
        }
        one=0; zero=0;
         for(int i=n-1;i>=0;i--){
             rightZeros[i] = zero;
             rightOnes[i] = one;
            if(s.charAt(i)=='0'){
                zero++;
            }else{
                one++;
            }
        }
        for(int i=1;i<n-1;i++){
             if(s.charAt(i)=='0'){
               ans += leftOnes[i]*rightOnes[i];
            }else{
                ans += leftZeros[i]*rightZeros[i];
            }
        }
        return ans;
    }
}