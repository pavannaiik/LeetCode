class Solution {
    public int trap(int[] height) {
        int waterTrapped =0;
        int left_max =0, right_max=0, i=0, j= height.length-1;
        while(i < j){
            if(height[i] < height[j]){
                left_max = Math.max(left_max, height[i]);
                waterTrapped += left_max-height[i];
                i++;
            }else{
                right_max = Math.max(right_max, height[j]);
                waterTrapped += right_max-height[j];
                j--;
            }
        }
        return waterTrapped;
    }
}