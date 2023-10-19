class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j= t.length()-1;
        String sb = "";
        String tb ="";
        Stack<Character> stack = new Stack<>();
        for(int p=0;p<s.length();p++){
            if(s.charAt(p)=='#' && !stack.isEmpty()){
                stack.pop();
            }else{
                if(s.charAt(p)!='#')
                stack.push(s.charAt(p));
            }
        }
        while(!stack.isEmpty()){
            sb = stack.peek() + sb;
            stack.pop();
        }
        for(int p=0;p<t.length();p++){
            if(t.charAt(p)=='#' && !stack.isEmpty()){
                stack.pop();
            }else{
                if(t.charAt(p)!='#')
                stack.push(t.charAt(p));
            }
        }
        while(!stack.isEmpty()){
            tb = stack.peek() + tb;
            stack.pop();
        }
        return sb.equals(tb);
    }
}