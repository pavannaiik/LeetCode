class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length,cols=matrix[0].length;
        int start=0,end=rows*cols-1;
        while(start<=end){
            int mid=(start+end)/2;
            int curRow=mid/cols;
            int curCol=mid%cols;
            if(matrix[curRow][curCol]==target)
                return true;
            else if(matrix[curRow][curCol]>target)
                end=mid-1;
            else start=mid+1;
        }
        return false;
    }
}