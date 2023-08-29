class Solution {
    public int findMin(int[] nums) {
        int left =0, right= nums.length-1;
        if(nums.length==0 || nums[left]<= nums[right]) return nums[left];
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }else if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(nums[mid]>nums[left]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        
        return -1;
        
    }
}