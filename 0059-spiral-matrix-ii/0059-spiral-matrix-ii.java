class Solution {
    public int[][] generateMatrix(int n) {
        //List<Integer>result = new ArrayList<>();
        int[][] res = new int[n][n];
        int val =1;
        int rows=n,cols=n;
        int up=0,down =rows-1,left=0,right=cols-1;
        int direction =0;
        while(val <= n*n){
            if(direction==0){
                for(int i=left;i<=right;i++){
                    res[up][i]=val++;
                }
                up++;
            }else if(direction==1){
                for(int i=up;i<=down;i++){
                    res[i][right]=val++;
                }
                right--;
            }
            else if(direction==2){
                for(int i=right;i>=left;i--){
                    res[down][i]=val++;
                }
                down--;
            }else if(direction==3){
                for(int i=down;i>=up;i--){
                    res[i][left]=val++;
                }
                left++;
            }
            direction = (direction+1)%4;
        }
        return res;
    }
}