public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans  = 0;
        int power =31;
        while(n !=0){
            ans += (n&1) << power;
            n = n>>>1;
            power -=1;
        }
        return ans;
    }
}