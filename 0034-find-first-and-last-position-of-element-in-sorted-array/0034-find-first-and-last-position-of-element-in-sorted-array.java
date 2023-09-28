class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int[] res = new int[]{-1,-1};
        int l=0,r=nums.length;
         while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]<=target){
                l=mid+1;
            }else{
                r = mid;
            }
        }
        if(l-1 ==-1 || nums[l-1]!=target){
            return new int[]{-1,-1};
        }
        res[1]=l-1;
        r = l-1;
        l=0;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]<target){
               l=mid+1;
            }else {
               r=mid;
            }
        }
        res[0]=l;
        return res;
        
    }
}