class Solution {
    List<List<String>>res = new ArrayList<>();
    List<List<String>>board = new ArrayList<>();
    Set<Integer>cols = new HashSet<>();
    Set<Integer>posDiag = new HashSet<>();
    Set<Integer>negDiag = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        for(int i =0;i<n;i++){
            List<String>temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                temp.add(".");
            }
            board.add(temp);
        }
        backtrack(0,n);
        return res;
    }
    public void backtrack(int r,int n){
        if(r == n){
            // Creating a List to store the concatenated strings
        List<String> copy = new ArrayList<>();

        // Concatenating strings in each row
        for (List<String> row : board) {
            copy.add(String.join("", row));
        }
            res.add(copy);
            return;
        }
        for(int c =0;c<n;c++){
            if (cols.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)){
                continue;
            }
            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);
            board.get(r).set(c,"Q");
            backtrack(r+1,n);
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            board.get(r).set(c,".");
        }
    }
}