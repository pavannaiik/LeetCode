class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int left_max = height[0], right_max = height[len - 1], left = 0, right = len - 1;
        int ans = 0;

        while(left < right){
            if(height[left] <= height[right]){
                 left_max = Math.max(left_max, height[left]);
                  ans+= left_max- height[left];
                  left++;
            }else{
                right_max = Math.max(right_max, height[right]);
                ans+= right_max - height[right];
                right--;
            }
           
            
        }

        return ans;
    }
}