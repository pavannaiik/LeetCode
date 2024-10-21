class Solution {
public:
    vector<pair<int,int>>dir = {{0,1},{0,-1},{1,0},{-1,0}};

    void wallsAndGates(vector<vector<int>>& rooms) {
        int n= rooms.size(),m=rooms[0].size();
        queue<pair<int,int>>q;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j]==0){
                    q.push({i,j});
                }
            }
        }
        // this approch works as the empty cells are filled by neared gate first and 
        // we are only filling if the gate is empty 
        while(!q.empty()){
            pair p = q.front();
            q.pop();
            int r = p.first;
            int c= p.second;
            for(int i=0;i<4;i++){
                int R=r+dir[i].first;
                int C=c+dir[i].second;
                if(R<0 || R>=n || C <0 || C>= m || rooms[R][C] != INT_MAX){
                    continue;;
                }
                rooms[R][C]=1+rooms[r][c];
                q.push({R,C});
            }

        }
    }
};