class Solution {
   public int mergeSort(int[] nums,int left,int right){
       if(left>=right) return 0;
       int mid=(right+left)/2;
       int count=mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);
       for(int i=left,j=mid+1;i<=mid;i++){
           while(j<=right && nums[i]/2.0 >nums[j])
               j++;
           count+=(j-(mid+1));
       }
       Arrays.sort(nums,left,right+1);
       return count;
   }
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}