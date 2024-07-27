class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>>set = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    List<List<Integer>>list = new ArrayList<>();
                    dfs(grid, i, j, i, j, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    public void dfs(int[][] grid, int i, int j, int baseR, int baseC, List<List<Integer>>list){
        if(i < 0 || i >= grid.length || j <0 || j>=grid[0].length || grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        List<Integer>temp = new ArrayList<>();
        temp.add(i-baseR);
        temp.add(j-baseC);
        list.add(new ArrayList<>(temp));
        dfs(grid, i, j+1, baseR, baseC,list);
        dfs(grid, i, j-1, baseR, baseC,list);
        dfs(grid, i+1, j, baseR, baseC,list);
        dfs(grid, i-1, j, baseR, baseC,list);

    }
}