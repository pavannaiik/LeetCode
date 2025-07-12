class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        //find pivot
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if( i>=0){
            //find next greater element than pivot which is a successor
            int j = n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            //swap them
            swap(nums, i, j);

        }
        //reverse elements after successor
        reverse(nums, i+1, nums.length-1);

    }
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
    }
}