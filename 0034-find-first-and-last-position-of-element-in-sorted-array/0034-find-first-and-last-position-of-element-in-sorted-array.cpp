class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int>ans={-1,-1};
        int low=0, high= nums.size();
        while(low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]<=target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        if(low-1==-1 || nums[low-1]!=target){
            return ans;
        }
        int r=low-1;
        int l = findLow(nums, 0, r, nums[r]);
        ans[0]=l;
        ans[1]=r;
        return ans;
    }
    int findLow(vector<int>&nums, int low, int high, int t){
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]<t){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
};