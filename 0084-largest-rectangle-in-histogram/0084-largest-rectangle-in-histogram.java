class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer,Integer>>stack = new Stack<>();
        int max_area=0;
        int n = heights.length;
        for(int i=0;i<heights.length;i++){
            int min_index=i;
            while(!stack.isEmpty() && stack.peek().getValue() > heights[i]){
                Pair<Integer,Integer> p = stack.pop();
                int index = p.getKey();
                int height=p.getValue();
                max_area = Math.max(max_area, (i-index)*height);
                min_index=Math.min(min_index, index);
            }
            stack.add(new Pair<>(min_index, heights[i]));
        }
        while(!stack.isEmpty()){
            Pair<Integer,Integer> p = stack.pop();
            int index = p.getKey();
            int height=p.getValue();
            max_area = Math.max(max_area, (n-index)*height);
        }
        return max_area;
    }
}