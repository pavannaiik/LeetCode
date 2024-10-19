class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        vector<vector<int>>dir ={{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        if(grid[0][0]==1) return -1;
        queue<vector<int>>queue;
        queue.push({0,0,0});
        int n =grid.size();
        int m =grid[0].size();
        while(!queue.empty()){
            vector<int>a = queue.front();
            queue.pop();
            int r =a[0];
            int c=a[1];
            int dis=a[2];
            if(r==n-1 && c==m-1){
                return dis+1;
            }
            for(auto d:dir){
                int nr = r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0){
                    queue.push({nr,nc,dis+1});
                    grid[nr][nc]=-1;
                }
            }
        }
        return -1;
    }
};