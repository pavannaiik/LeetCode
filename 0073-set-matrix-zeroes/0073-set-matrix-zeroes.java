class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int col0 = -1, row0=-1;
        for(int i=0;i<m;i++){
            if(matrix[0][i]==0){
                row0=0;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                col0=0;
                break;
            }
        }

        for(int i=1;i<n;i++){
            for(int j =1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=n-1;i>=1;i--){
            for(int j=m-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(row0==0){
            for(int i=0;i<m;i++){
            matrix[0][i]=0;
             }
        }
        if(col0==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    }
}