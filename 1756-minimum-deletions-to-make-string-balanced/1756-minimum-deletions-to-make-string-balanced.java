class Solution {
    public int minimumDeletions(String s) {
        Stack<Character>stack = new Stack<>();
        int ans =0;
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()=='b' && c=='a'){
                stack.pop();
                ans++;
            }else{
                stack.push(c);
            }
        }
        return ans;

    }
}