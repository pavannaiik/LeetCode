class Solution {
    public void moveZeroes(int[] nums) {
        int k =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
        }
        while(k < n){
            nums[k]=0;
            k++;
        }
    }
}