class Solution {
    public int firstMissingPositive(int[] nums) {
        //convert all the element which are less and greater than n to n+1 beacause we doesnt care them
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0 || nums[i]>n){
                nums[i]=n+1;
            }
        }
        
        // convert the correponding element to its index with changing sign
        
        for(int i=0;i<n;i++){
            int num = Math.abs(nums[i]);
            if(num>n) continue;
            num--;
            if(nums[num]>0){
                nums[num]= (-1*nums[num]);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                return i+1;
            }
        }
        return n+1;
    }
}
