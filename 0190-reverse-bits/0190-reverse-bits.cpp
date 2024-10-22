class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        // the idea is to shift the ith bit by 31 positions while calculating answer
        int ans  = 0;
        int power =31;
        while(n !=0){
            ans += (n&1) << power;
            n = n>>1;
            power -=1;
        }
        return ans;
    }
};