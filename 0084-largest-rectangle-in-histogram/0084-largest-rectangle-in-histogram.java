public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea = 0;
       int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer>stack = new Stack<Integer>();
        for(int i=0;i<heights.length;i++){
            
            if(stack.isEmpty()){
                left[i]=0;
                stack.push(i);
            }else{
                
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();
            }
            if(stack.size()>0)
            left[i]=(stack.peek()+1);
            else left[i]=0;
            stack.push(i);
            }
        }
        while(!stack.isEmpty()) stack.pop();
        for(int i=heights.length-1;i>=0;i--){
           if(stack.isEmpty()){
                right[i]=heights.length-1;
                stack.push(i);
            }else{
                
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                stack.pop();
            }
            if(stack.size()>0)
            right[i]=(stack.peek()-1);
            else right[i]=heights.length-1;
            stack.push(i);
            }
        }
        for(int i=0;i<heights.length;i++){
            maxarea = Math.max(maxarea,heights[i]*(right[i]-left[i]+1));
        }
        return maxarea;
    }
}