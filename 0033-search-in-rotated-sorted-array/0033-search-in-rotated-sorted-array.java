class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(nums[0]==target) return 0;
        if(nums[n-1]==target) return n-1;
        int i=0, j=n-1;
        while(i <= j){
            int mid = i+(j-i)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[i] <= nums[mid]){
                if(nums[i] <= target && nums[mid]>=target){
                    j=mid-1;
                }else{
                    i= mid+1;
                }
            }else{
                if(nums[mid] <=target && nums[j] >= target){
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }
        }
        return -1;
    }
}