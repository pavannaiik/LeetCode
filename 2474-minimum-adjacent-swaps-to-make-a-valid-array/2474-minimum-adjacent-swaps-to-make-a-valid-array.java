class Solution {
    public int minimumSwaps(int[] nums) {
        if(nums.length==1) return 0;
        int min = Integer.MAX_VALUE, max =0;
        int minIndex = nums.length;
        int maxIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < min){
                min=nums[i];
                minIndex = i;
            }
            if(nums[i] >= max){
                max= nums[i];
                maxIndex = i;
            }
        }
        if(minIndex < maxIndex){
            return minIndex + nums.length-maxIndex-1;
        }else{
            return minIndex+nums.length-maxIndex-2;
        }
        
    }
}