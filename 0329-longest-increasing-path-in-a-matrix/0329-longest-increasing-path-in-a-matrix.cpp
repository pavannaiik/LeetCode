class Solution {
    vector<vector<int>>dir ={{0,1},{0,-1},{1,0},{-1,0}};
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int ma =1;
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>>cache(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ma=max(ma, dfs(i,j,n,m,matrix,cache));
            }
        }
        return ma;
    }
    int dfs(int i, int j, int n,int m,vector<vector<int>>& matrix, vector<vector<int>>&cache ){
        if(cache[i][j]!=0) return cache[i][j];
        for(vector<int>dir:dir){
            int r=i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r<n && c>=0 && c<m && matrix[i][j] < matrix[r][c]){
                cache[i][j]=max(cache[i][j], dfs(r,c,n,m,matrix,cache));
            }
        }
        return ++cache[i][j];
    }
};