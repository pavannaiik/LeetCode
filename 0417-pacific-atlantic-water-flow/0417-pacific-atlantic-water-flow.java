class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>answer = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i, 0, pacific, heights, heights[i][0]);
            dfs(i, n-1, atlantic,heights, heights[i][n-1]);
        }
        for(int i=0;i<n;i++){
            dfs(0, i, pacific, heights, heights[0][i]);
            dfs(m-1, i, atlantic,heights, heights[m-1][i]);
        }
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    answer.add(List.of(i, j));
                }
            }
        }
        return answer;
    }
    public void dfs(int i, int j, boolean[][] visited, int[][] heights, int prevValue){
        if(i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || visited[i][j] || heights[i][j] < prevValue){
            return;
        }
        visited[i][j] = true;
        dfs(i, j+1, visited, heights, heights[i][j]);
        dfs(i, j-1, visited, heights, heights[i][j]);
        dfs(i+1, j, visited, heights, heights[i][j]);
        dfs(i-1, j, visited, heights, heights[i][j]);
    }
}