class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1, j=1;
        int n = nums.length;
        while(j <n){
            if(nums[j]==nums[j-1]){
                j++;
                continue;
            }
            nums[i++]=nums[j++];
        }
        return i;
    }
}