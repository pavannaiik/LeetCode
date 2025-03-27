class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int open=0;
        for(int i=0;i<n;i++){
            char ch = sb.charAt(i);
            if(ch=='(') open++;
            else if(ch==')') open--;
            if(open <  0){
                sb.setCharAt(i, '#');
                open++;
            }
        }
        
        StringBuilder res= new StringBuilder();
        for(int i=n-1;i>=0;i--){
            char ch = sb.charAt(i);
            if(ch=='(' && open >0) {
                open--;
                continue;
            }
            if(ch!='#'){
                res.append(ch);
            }
        }
        return res.reverse().toString();
    }
}