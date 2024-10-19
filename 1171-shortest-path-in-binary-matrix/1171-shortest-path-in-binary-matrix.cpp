class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& a) {
        int n=a.size();
        queue<pair<int,pair<int,int>>>q;
        vector<vector<int>>vis(n,vector<int>(n,0));
        if(a[0][0])return -1;
        q.push({1,{0,0}});
        vis[0][0]=1;
        while(!q.empty()){
            auto k=q.front();
            q.pop();
            int dist=k.first;
            int r=k.second.first,c=k.second.second;
            if(r==n-1 && c==n-1)return dist;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int x=r+i,y=c+j;
                    if(x>=0 && x<n && y>=0 && y<n && a[x][y]==0 && vis[x][y]==0){
                        q.push({dist+1,{x,y}});
                        vis[x][y]=1;
                    }
                }
            }
        }
        return -1;
    }
};