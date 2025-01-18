class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(int i:nums) sum+=i;
        int n = nums.length;
        int ans=0;
        long curSum=0;
        for(int i=0;i<n;i++){
            curSum+=nums[i];
            if(curSum >= sum-curSum && i!=n-1){
                ans++;
            }
        }
        return ans;
    }
}