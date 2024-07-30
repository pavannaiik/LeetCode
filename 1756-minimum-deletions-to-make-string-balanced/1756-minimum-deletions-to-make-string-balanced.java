class Solution {
    public int minimumDeletions(String s) {
        int c_a=0, c_b=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') c_a++;
        }
        int ans =Integer.MAX_VALUE;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='a') c_a--;
            ans = Math.min(ans, c_a+c_b);
            if(s.charAt(j)=='b') c_b++;
        }
        return ans;

    }
}