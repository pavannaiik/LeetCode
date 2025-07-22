

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n==1) return nums;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for(int i=1;i<n;i++){
            ans[i] = ans[i-1] * nums[i];
        }
        int rightProd = nums[n-1];
        ans[n-1] = ans[n-2];
        for(int i=n-2;i>0;i--){
            ans[i] = ans[i-1] * rightProd;
            rightProd *= nums[i];
        }
        ans[0] = rightProd;
        return ans;
    }
}