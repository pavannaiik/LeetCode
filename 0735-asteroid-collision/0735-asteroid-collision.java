class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack = new Stack<>();
        for(int asteroid: asteroids){
            int flag =0;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                if(Math.abs(asteroid) < stack.peek()){
                    flag = 1;
                    break;
                }else if(Math.abs(asteroid) == stack.peek()){
                    flag =1;
                    stack.pop();
                    break;
                }
                stack.pop();
            }
            if(flag ==0)
            stack.add(asteroid);
        }
        int n = stack.size();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}