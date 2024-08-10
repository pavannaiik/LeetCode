class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            nums[i]= a*x*x + b*x + c;
        }
        Arrays.sort(nums);
        return nums;
    }
    
}