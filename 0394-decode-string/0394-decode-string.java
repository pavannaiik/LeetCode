class Solution {
    public String decodeString(String s) {
        Stack<Character>stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                while(!stack.isEmpty() && stack.peek()!='['){
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                int num=0, base=1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num += (stack.peek()-'0')*base;
                    base*=10;
                    stack.pop();
                }
                StringBuilder newSB = new StringBuilder(sb);
                while(num-->1){
                    sb.append(newSB);
                }
                for(char c:sb.toString().toCharArray()){
                    stack.push(c);
                }
                sb = new StringBuilder();
                
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
}