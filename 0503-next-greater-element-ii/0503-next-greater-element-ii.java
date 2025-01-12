class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>stack = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                ans[stack.peek()]=nums[i];
                stack.pop();
            }
            stack.add(i);
        }
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()] && ans[stack.peek()]==-1){
                ans[stack.peek()]=nums[i];
                stack.pop();
            }
        }
        return ans;

    }
}