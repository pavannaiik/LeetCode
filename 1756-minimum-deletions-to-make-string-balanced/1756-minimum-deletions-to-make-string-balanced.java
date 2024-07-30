class Solution {
    public int minimumDeletions(String s) {
        int[] count_a = new int[s.length()];
        int c_a=0, c_b=0;
        int i=0;
        for(int j=s.length()-1;j>=0;j--){
            char c = s.charAt(j);
            count_a[j] = c_a;
             if(c=='a'){
                c_a++;
            }
        }

        int ans =Integer.MAX_VALUE;
        for(int j=0;j<s.length();j++){

            ans = Math.min(ans, count_a[j]+c_b);
            if(s.charAt(j)=='b') c_b++;
        }
        return ans;

    }
}