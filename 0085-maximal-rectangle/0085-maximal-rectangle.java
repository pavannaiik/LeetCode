class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans =0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] curRow = new int[matrix[0].length];
        int[] left =new int[matrix[0].length];
        int[] right =new int[matrix[0].length];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]-'0' !=0)
                curRow[j]+=(matrix[i][j]-'0');
                else{
                    curRow[j]=0;
                }
            }
                left[0]=-1;
                right[m-1]=m;
                for(int k=1;k<m;k++){
                    int p=k-1;
                    while(p>=0 && curRow[k] <= curRow[p] ){
                        p=left[p];
                    }
                    left[k]=p;
                }
            for(int k=m-2;k>=0;k--){
                    int p=k+1;
                    while(p < curRow.length && curRow[k] <= curRow[p] ){
                        p=right[p];
                    }
                    right[k]=p;
                }
            for(int q=0;q<m;q++){
                ans= Math.max(ans, curRow[q]*(right[q]-left[q]-1));
            }
            
        }
        return ans;
    }
}