class Solution {
    public int missingElement(int[] nums, int k) {
       // int totalMissingNumbers =0;
        int n =k;
        for(int i=1;i<nums.length;i++){
            if(n <= nums[i]-nums[i-1] - 1 ){
                return nums[i-1]+n;
            }else{
                int totalMissingNumbers =(nums[i]-nums[i-1]-1);
                n-=totalMissingNumbers;
            }
        }
        return nums[nums.length-1]+n;
    }
}