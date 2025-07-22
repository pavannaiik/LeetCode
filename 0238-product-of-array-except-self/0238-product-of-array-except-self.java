

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n==1) return nums;
        int[] leftProd = new int[n];
        leftProd[0] = nums[0];
        for(int i=1;i<n;i++){
            leftProd[i] = leftProd[i-1] * nums[i];
        }
        int rightProd = nums[n-1];
        leftProd[n-1] = leftProd[n-2];
        for(int i=n-2;i>0;i--){
            leftProd[i] = leftProd[i-1] * rightProd;
            rightProd *= nums[i];
        }
        leftProd[0] = rightProd;
        return leftProd;
    }
}