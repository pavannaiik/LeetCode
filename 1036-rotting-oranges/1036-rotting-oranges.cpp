class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n= grid.size(),m=grid[0].size();
        int freshOranges=0;
        queue<pair<int,int>>queue;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.push({i,j});
                }else if(grid[i][j]==1) freshOranges++;
            }
        }
        if(freshOranges==0) return 0;
        int minutes=0;
        vector<pair<int,int>>dir ={{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.empty()){
            minutes++;
            int len = queue.size();
            for(int i=0;i<len;i++){
                pair p = queue.front();
                queue.pop();
                int r = p.first;
                int c=  p.second;
                for(int j=0;j<4;j++){
                    int R=r+dir[j].first;
                    int C=c+dir[j].second;
                    if(R<0 || R>=n || C <0 || C>= m || grid[R][C] != 1){
                        continue;;
                    }
                    grid[R][C]=2;
                    queue.push({R,C});
                    freshOranges--;
                }
            }
        }
        return freshOranges == 0 ? minutes-1 : -1;;
    }
};