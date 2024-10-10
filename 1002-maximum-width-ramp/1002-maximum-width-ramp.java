class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer>stack = new Stack<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(stack.isEmpty() || nums[i] < nums[stack.peek()] ){
                stack.push(i);
            }
        }
        int right = n-1;
        int maxWidth =0;
        while(right>=0){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[right]){
                maxWidth = Math.max(maxWidth, right-stack.peek());
                stack.pop();
            }
            right--;
        }
        return maxWidth;

    }
}