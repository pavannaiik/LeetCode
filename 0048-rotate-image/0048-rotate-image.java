class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=i;j<rows;j++){
                int t = matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=t;
            }
        }
        for(int i=0;i<rows;i++){
            int p=0, q=cols-1;
            while(p<q){
                int t = matrix[i][p];
                matrix[i][p]=matrix[i][q];
                matrix[i][q]=t;
                p++;
                q--;
            }
        }
    }
}