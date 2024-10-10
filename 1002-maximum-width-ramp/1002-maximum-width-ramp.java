class Solution {
    public int maxWidthRamp(int[] nums) {
        int size = nums.length;
        Integer[] rightMax = new Integer[size];
        rightMax[size-1]=nums[size-1];
        for(int i=size-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],nums[i]);
        }
        int maxWidth =0;
        int right = 0, left=0;
        while(right<size){
            if(left < right && nums[left ]>rightMax[right]){
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }
        return maxWidth;

    }
}