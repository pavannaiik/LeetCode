class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left =0;
        for(int right =0;right < n;right++){
            if(nums[right]!=0){
                int t = nums[right];
                nums[right]=nums[left];
                nums[left]=t;
                left++;
            }
        }
    }
}