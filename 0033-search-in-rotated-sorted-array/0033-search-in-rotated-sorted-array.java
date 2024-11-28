class Solution {
    public int search(int[] nums, int target) {
        int i=0, j= nums.length-1;
        if(nums[0]==target) return 0;
        if(nums[j]==target) return j;
        while( i <= j){
            int mid = i+(j-i)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[i] <= nums[mid]){
                if(target > nums[mid] || target < nums[i]){
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }else{
                if(target < nums[mid] || target > nums[j]){
                    j=mid-1;
                }else{
                    i=mid+1;
                }
            }
        }
        return -1;
    }
}