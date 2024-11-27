class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>stack = new Stack<>();
        for(int asteroid:asteroids){
            int flag=1;
            while(!stack.isEmpty() && (stack.peek() >0 && asteroid <0)){
                if( Math.abs(stack.peek())< Math.abs(asteroid))
                    {
                    stack.pop();
                    continue;
                    }else if(Math.abs(stack.peek()) == Math.abs(asteroid)){
                    stack.pop();
                }
                flag=0;
                break;
            }
            if(flag==1) stack.add(asteroid);
        }
        System.out.println(stack);
        int[] ans = new int[stack.size()];
        while(!stack.isEmpty()){
            ans[stack.size()-1]=stack.peek();
            stack.pop();
        }
        return ans;
    }
}