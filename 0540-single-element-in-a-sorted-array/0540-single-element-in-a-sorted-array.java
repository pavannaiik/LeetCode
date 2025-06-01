class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low =0, high = nums.length-1;
        while(low < high){
            int mid = low+(high-low)/2;
            if((mid-1 >=0 && nums[mid]!=nums[mid-1] )&& (mid+1 <=nums.length-1 &&nums[mid]!=nums[mid+1])){
                return nums[mid];
            }else if(mid-1 >=0 && nums[mid]==nums[mid-1]){
                if(mid%2==1){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }else if(mid+1 <= nums.length-1 && nums[mid]==nums[mid+1]){
                if(mid%2==0){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }else{
                break;
            }
        }
        return nums[low];
    }
}