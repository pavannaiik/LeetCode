class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        vector<int>vis(n,0);
        vector<vector<int>>adj(n);
        for(auto e:edges){
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        if (!dfs(adj, vis, -1, 0)) {
            return false;  // Cycle detected
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) return false;
        }
        return true;
    }
    bool dfs(vector<vector<int>>&adj, vector<int>&vis, int prev, int i){
        vis[i]=1;
        for(int neigh:adj[i]){
            if (neigh == prev) continue;
            if(vis[neigh]==1){
                return false;
            }
            if (!dfs(adj, vis, i, neigh)) return false;
        }
        return true;
    }
};