public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
       int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0]=-1;
        right[heights.length-1]=heights.length;
        for(int i=1;i<heights.length;i++){
            int p =i-1;
            while(p>=0 && heights[i]<=heights[p]){
                p=left[p];
            }
            left[i]=p;
        }
        for(int i=heights.length-2;i>=0;i--){
           int p=i+1;
            while(p<heights.length && heights[i]<=heights[p]){
                p=right[p];
            }
            right[i]=p;
            
        }
        for(int i=0;i<heights.length;i++){
            maxarea = Math.max(maxarea,heights[i]*(right[i]-left[i]-1));
        }
        return maxarea;
    }
}