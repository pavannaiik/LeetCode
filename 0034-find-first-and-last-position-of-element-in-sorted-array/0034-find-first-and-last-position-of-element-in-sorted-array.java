class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i=0, j=n-1;
        int[] ans={-1,-1};
        if(n==0) return ans;
        while(i <= j){
            int mid = i+(j-i)/2;
            if(nums[mid]==target){
                ans[0]= searchLeft(nums, target,0, mid);
                ans[1]=searchRight(nums, target, mid, n-1);
                return ans;
            }else if(nums[mid]>target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return ans;
    }
    public int searchLeft(int[] nums, int target, int i, int j){
        while(i <= j){
            int mid=i+(j-i)/2;
            if(nums[mid] >= target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;
    }
    public int searchRight(int[] nums, int target, int i, int j){
        while(i <= j){
            int mid=i+(j-i)/2;
            if(nums[mid] <= target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i-1;
    }
}