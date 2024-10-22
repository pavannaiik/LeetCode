class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int xo=0;
        for(int n:nums){
            xo=xo^n;
        }
        return xo;
    }
};