class NumMatrix {
    vector<vector<int>>ans;
public:
    NumMatrix(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        ans = vector<vector<int>>(n+1,vector<int>(m+1,0));
        for(int i=0;i<n;i++){
            int preFixSum=0;
            for(int j=0;j<m;j++){
                preFixSum += matrix[i][j];
                int aboveCellSum = ans[i][j+1]; //above of i+1, j+1 
                ans[i+1][j+1]=preFixSum + aboveCellSum;//+1 because we added extra col,row so 1-offset
            }
        }

    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        //add 1 to co-ordinates because we offset by 1
        row1+=1;
        row2+=1;
        col1+=1;
        col2+=1;
        int curCellSum = ans[row2][col2];
        int aboveCellSum = ans[row1-1][col2];
        int leftCellSum = ans[row2][col1-1];
        int topLeftCell = ans[row1-1][col1-1];
        return curCellSum-aboveCellSum-leftCellSum+topLeftCell;
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */