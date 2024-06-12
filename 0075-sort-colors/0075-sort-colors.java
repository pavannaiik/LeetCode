class Solution {
    public void sortColors(int[] nums) {
       int low =0,mid =0, high = nums.length-1;
       //everything starts from 0 to low-1 are zeros
       //everything starts from low to mid-1 are ones
       //everything starts from mid to high are twos
       //we can use other method which keeps track of how many ones
       // twos and zeros present then simply replace first zero element 
       // to respective numbers similar to twos and ones as well
       while(mid<=high){
        if(nums[mid]==0){
            swap(nums,low,mid);
            low++;
            mid++;
        }else if(nums[mid]==2){
            swap(nums,mid,high);
            high--;
        }else{
            mid++;
        }
       }
    }
    public void swap(int nums[],int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}