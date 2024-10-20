class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int noZeroProduct=1;
        int zeroCount=0;
        for(int n:nums){
            if(n==0){
                zeroCount++;
            }else{
                noZeroProduct *=n;
            }
        }
        vector<int>ans(nums.size());
        int i=0;
        for(int n:nums){
            if(n==0 && zeroCount==1){
                ans[i]=noZeroProduct;
            }else if(n!=0 && zeroCount>0){
                ans[i]=0;
            }else if(n!=0 && zeroCount==0){
                ans[i]=(noZeroProduct/n);
            }
            i++;
        }
        return ans;
    }

};