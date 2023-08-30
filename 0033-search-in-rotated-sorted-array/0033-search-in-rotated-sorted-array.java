class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int left=0,right=len-1;
        if(len==1){
            if(nums[0]==target) return 0;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>=nums[left]){
                if(target<=nums[mid]&& target>=nums[left]) right = mid-1;
                else left=mid+1;
            }else{
                if(target>=nums[mid] && target<=nums[right]) left =mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }
}