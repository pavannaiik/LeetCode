class Solution {
    public int reverse(int x) {
        int ans =0,prev =0;
        while(x!=0){
            int lastdigit = x%10;
            ans = (ans * 10 )+ lastdigit;
            if ((ans - lastdigit) / 10 != prev){
                return 0;
            }
            prev = ans;
            x = x/10;
        }
        return ans;
    }
}