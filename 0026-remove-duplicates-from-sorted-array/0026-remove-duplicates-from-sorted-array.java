class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1, j=1;
        int n = nums.length;
        while(j < n){
            if(nums[j]==nums[i-1]){
                j++;
            }else{
                nums[i]=nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}