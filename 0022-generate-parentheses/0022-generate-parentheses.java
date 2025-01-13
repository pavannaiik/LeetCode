class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result = new ArrayList<>();
        int open=0, closed=0;
        backtrack( n,open, closed, "", result);
        return result;
    }
    public void backtrack(int n,int open, int closed, String s, List<String>result){
        if(s.length()==2*n){
            result.add(s);
            return ;
        }
        if(open<n){
            backtrack( n, open+1, closed, s+"(", result);
        }
         if(closed<open){
            backtrack( n, open, closed+1, s+")", result);
        }
    }
}