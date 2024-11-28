class Solution {
    public int maxArea(int[] height) {
        int res =0;
        int i=0, j= height.length-1;
        while(i < j){
            if(height[i] < height[j]){
                res = Math.max(res, Math.min(height[i], height[j])*(j-i));
                i++;
            }else{
                res = Math.max(res,  Math.min(height[i], height[j])*(j-i));
                j--;
            }
        }
        return res;
    }
}