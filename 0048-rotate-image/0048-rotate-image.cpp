class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n= matrix.size(),m=matrix[0].size();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int t = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        for(int i=0;i<n;i++){
           int p=0, q=m-1;
           while(p<q){
                int t = matrix[i][p];
                matrix[i][p]=matrix[i][q];
                matrix[i][q]=t;
                p++;
                q--;
           }
        }

    }
};