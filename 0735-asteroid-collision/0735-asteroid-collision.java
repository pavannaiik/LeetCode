class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st = new Stack<>();
        for(int asteroid:asteroids){
            boolean flag = true;
            while(!st.isEmpty() && (st.peek() >0 && asteroid <0) ){
                if(Math.abs(asteroid) > Math.abs(st.peek())){
                    st.pop();
                    continue;
                }else if(Math.abs(asteroid) == Math.abs(st.peek())){
                    st.pop();
                }
                flag = false;
                break;
            }
            if(flag){
                st.push(asteroid);
            }
        }
       int[] ans = new int[st.size()];
       int i = st.size()-1;
        while(!st.isEmpty()){
           ans[i--]=st.pop();
        }
        return ans;
    }
}