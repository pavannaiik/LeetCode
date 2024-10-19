class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        int R= heightMap.size();
        int C = heightMap[0].size();
        vector<vector<int>>vis(R,vector<int>(C,0));
        int vol=0;
        //by deault pr in c++ is max heap so we have to declare greater and container for pq is vector
        priority_queue<pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>,greater<pair<int,pair<int,int>>>>pq;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(i==0 ||i==R-1 ||j==0||j==C-1){
                    pq.push({heightMap[i][j],{i,j}});
                    vis[i][j]=true;
                }
            }
        }
        int minBdHt=0;
        int dR[4]={0,0,1,-1};
        int dC[4]={1,-1,0,0};
        while(!pq.empty()){
            int curHt = pq.top().first;
            int curR = pq.top().second.first;
            int curC = pq.top().second.second;
            minBdHt = max(minBdHt, curHt);
            pq.pop();
            for(int i=0;i<4;i++){
                int tR = curR+dR[i];
                int tC =  curC +dC[i];
                if(tR >=0 && tR<R && tC >=0 && tC <C && vis[tR][tC]==false){
                    vis[tR][tC]=true;
                    pq.push({heightMap[tR][tC],{tR,tC}});
                    if(heightMap[tR][tC]<minBdHt){
                        vol += minBdHt-heightMap[tR][tC];
                    }
                }
            }
        }
        return vol;
    }
};