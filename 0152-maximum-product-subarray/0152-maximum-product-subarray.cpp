class Solution {
public:
    int maxProduct(vector<int>& nums) {
        //idea is to maintain max and min products 
        //such that it handles negative procuts
        int curMax=nums[0],curMin=nums[0],maxProd=curMax;
        int n=nums.size();
        for(int i=1;i<n;i++){
            int temp = curMax;
            curMax = max(nums[i],max(curMax*nums[i],curMin*nums[i]));
            curMin = min(nums[i],min(temp*nums[i],curMin*nums[i]));
            maxProd=max(curMax,maxProd);
        }
        return maxProd;
    }
};