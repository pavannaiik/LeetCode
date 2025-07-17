class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i =0, j = nums.length-1;
        int n = nums.length-1;
        while(i < j){
            int mid = i+ (j-i)/2;
            if( mid > 0 && nums[mid]!=nums[mid-1] && mid <n && nums[mid]!= nums[mid+1]){
                return nums[mid];
            }else if(mid > 0 && nums[mid] == nums[mid-1]){
                if(mid%2 !=0){
                    i = mid +1;
                }else{
                    j=mid-1;
                }
            }else if(mid < n && nums[mid] ==nums[mid+1]){
                if(mid%2 !=0){
                    j = mid-1;
                }else{
                     i=mid+1;
                }
            }else break;
        }
        return nums[i];
    }
}