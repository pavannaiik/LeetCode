class Solution {
public:
    
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        if(edges.size()==0) return{};
        vector<int> parent;
        parent.resize(edges.size()+1);
        for(int i=1;i<edges.size()+1;i++){
            parent[i]=i;
        }
        for(vector<int> edge : edges){
            int f1=find(edge[0],parent);
            int f2=find(edge[1],parent);
            if(f1!=f2)
                parent[f1]=f2;
            else
                return edge;
        }
        return {};
    }
    int find(int x,vector<int> parent){
        return parent[x]==x ? x : find(parent[x],parent);
    }
    
};