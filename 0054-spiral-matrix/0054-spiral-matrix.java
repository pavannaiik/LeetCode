class Solution {
        List<Integer>result = new ArrayList<>();
    int ans=0;
    public List<Integer> spiralOrder(int[][] matrix) {
        int cols= matrix[0].length;
        int rows = matrix.length;
       int up =0;
        int down = rows-1;
        int left =0;
        int right = cols-1;
        int direction =0;
        //0 - move right column  wise
        //1 move down row wise
        //2 move left column wise
        //3 move up row wise 
        while(result.size()<cols*rows){
            if(direction ==0){
                for(int i=left;i<=right;i++){
                    result.add(matrix[up][i]);
                }
                up++;
            }else if(direction ==1){
                for(int i=up;i<=down;i++){
                    result.add(matrix[i][right]);
                }
                right--;
            }else if(direction ==2){
                for(int i=right;i>=left;i--){
                    result.add(matrix[down][i]);
                }
                down--;
            }else if(direction ==3){
                for(int i=down;i>=up;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
            direction = ((direction+1)%4);
            
        }
        return result;
    }
}