class Solution {
    public int removeDuplicates(int[] nums) {
        int ans =0;
        int i=0, j=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
                ans++;
            }
            j++;
        }
        return ans+1;
    }
}