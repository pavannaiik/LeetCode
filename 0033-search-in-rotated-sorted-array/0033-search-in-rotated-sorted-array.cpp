class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low=0, high=nums.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            //left portion search
            if(nums[low] <= nums[mid]){
                if(target > nums[mid] || target < nums[low]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            //right portion
            else{
                if(target < nums[mid] || target >nums[high]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        return -1;
    }
};