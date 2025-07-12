class Solution {
    public int removeDuplicates(int[] nums) {
        int left =0, right =1;
        int n = nums.length;
        while(right < n){
            if(nums[left]!=nums[right]){
                left++;
                nums[left]= nums[right];
            }
            right++;
        }
        return left+1;
    }
}