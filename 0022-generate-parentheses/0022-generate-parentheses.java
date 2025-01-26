class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result = new ArrayList<>();
        int open=0, closed=0;
        backtrack( n,open, closed, new StringBuilder(), result);
        return result;
    }
    public void backtrack(int n,int open, int closed, StringBuilder sb, List<String>result){
        if(sb.length()==2*n){
            result.add(sb.toString());
            return ;
        }
        if(open<n){
            sb.append("(");
            backtrack( n, open+1, closed, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
         if(closed<open){
            sb.append(")");
            backtrack( n, open, closed+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}