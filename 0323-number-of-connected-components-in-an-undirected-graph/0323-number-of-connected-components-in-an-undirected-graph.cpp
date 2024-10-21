class Solution {
public:
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<int>vis(n,0);
        vector<vector<int>>adj(n);
        for(auto e:edges){
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(adj,vis,i);
                count++;
            }
        }
        return count;
    }
    void dfs(vector<vector<int>>&adj, vector<int>&vis, int node){
        if(vis[node]==1){
            return;
        }
        vis[node]=1;
        for(int n:adj[node]){
            if(vis[n]==0){
                dfs(adj,vis,n);
            }
        }
        return;
    }
};