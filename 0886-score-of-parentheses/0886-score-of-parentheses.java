class Solution {
    public int scoreOfParentheses(String s) {
        int score =0;
        Stack<Integer>stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(score);
                score=0;
            }else{
                score = stack.pop()+ Math.max(score *2,1);
            }
        }
        return score;
    }
}