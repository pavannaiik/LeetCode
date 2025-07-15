class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0,j=nums.length;
        while(i<j){
            int mid = (i+j)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target){
                i= mid+1;
            }else if(nums[mid]>target){
                j=mid-1;
            }
        }
        if( i>=0 && i< nums.length && nums[i]<target) return i+1;
        return i;
    }
}