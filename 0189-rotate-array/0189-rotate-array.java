class Solution {
    public void rotate(int[] nums, int k) {
       int n = nums.length;
        k = k % nums.length;
        swapNums(nums, 0, n-1);
        swapNums(nums, 0, k-1);
        swapNums(nums, k, n-1);
 
}
    private void swapNums(int[] nums, int i, int j){
        while(i<j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
        i++;
        j--;
        }
    }
}