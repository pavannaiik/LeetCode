class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack = new Stack<>();
        for(int asteroid:asteroids){
            int flag =0;
            while(!stack.isEmpty()){
               if(asteroid < 0 && stack.peek() < 0){
                break;
               }else if(asteroid < 0  && stack.peek() > 0 && Math.abs(asteroid) > stack.peek()){
                stack.pop();
               }else if(asteroid < 0  && stack.peek() > 0 && Math.abs(asteroid) == stack.peek()){
                stack.pop();
                flag =1;
                break;
               }else if(asteroid < 0  && stack.peek() > 0 && Math.abs(asteroid) < stack.peek()){
                flag =1;
                break;
               }else{
                break;
               }
            }
            if(flag==0){
                stack.push(asteroid);
            }
        }
       int[] ans = new int[stack.size()];
       int i = stack.size()-1;
        while(!stack.isEmpty()){
           ans[i--]=stack.pop();
        }
        return ans;
    }
}