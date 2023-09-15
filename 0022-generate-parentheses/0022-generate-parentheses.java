class Solution {
    public List<String> generateParenthesis(int n) {
        //using backtracking
        List<String>result = new ArrayList<>();
        int open =0,closed=0;
        String res="";
        backtrack(result, open, closed, res,n);
        return result;
    }
    public void backtrack(List<String>result,int open,int closed,String res,int n){
            if(res.length()== n*2){
                result.add(res);
                return;
            }
            if(open<n){
                backtrack(result,open+1,closed,res+"(",n);
            }
            if(closed < open){
                backtrack(result,open,closed+1,res+")",n);
            }
        }
}