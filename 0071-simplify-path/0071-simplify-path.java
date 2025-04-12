class Solution {
    public String simplifyPath(String path) {
        Stack<String>stack = new Stack<>();
        String[] str = path.split("/");
        StringBuilder sb = new StringBuilder();
        for(String s: str){
            if(s.equals("/") || s.isEmpty() || s.isBlank()) continue;
            if(s.equals(".")){
                continue;
            }else if(s.equals("..") && !stack.isEmpty()){
                stack.pop();
                continue;
            }
            if(!s.equals(".."))
            stack.push(s);
        }
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0,'/');
        }
        return sb.toString();
    }
}