class Solution {
  public void moveZeroes(int[] nums) {
    int i=0, si=0;
    int n = nums.length;
    while(si < n ){
        if(nums[si]!=0){
            int t = nums[si];
            nums[si]= nums[i];
            nums[i]=t;
            i++;
        }
        si++;
    }
  }
}