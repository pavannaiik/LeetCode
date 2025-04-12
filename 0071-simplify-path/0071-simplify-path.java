class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String>stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(String s: str){
            if(s.equals("/") || s.isBlank() || s.isEmpty()) continue;
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
            result.insert(0, stack.pop());
            result.insert(0,'/');
        }
        return result.toString();
    }
}

