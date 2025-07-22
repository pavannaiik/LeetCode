class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer,Integer>>stack = new Stack<>();
        int max_area =0;
        int n = heights.length;
        for(int i=0;i<n;i++){
            int min_index = i;
            while(!stack.isEmpty() && stack.peek().getKey() > heights[i]){
                max_area = Math.max(max_area, stack.peek().getKey() * (i-stack.peek().getValue()));
                min_index = Math.min(min_index, stack.peek().getValue());
                stack.pop();

            }
            stack.add(new Pair<>(heights[i], min_index));
        }
        while(!stack.isEmpty()){
            max_area = Math.max(max_area, stack.peek().getKey() * (n-stack.peek().getValue()));
            stack.pop();
        }
        return max_area;
    }
}