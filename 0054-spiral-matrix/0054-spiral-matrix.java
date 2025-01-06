class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int dir=0;
        List<Integer>ans=new ArrayList<>();
        int up=0, down =matrix.length-1;
        int left=0, right = matrix[0].length-1;
        int n = matrix.length, m = matrix[0].length;

        while(ans.size()!= n*m ){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    ans.add(matrix[up][i]);
                }
                up++;
            }else if(dir==1){
                for(int i=up;i<=down;i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }else if(dir==2){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[down][i]);
                }
                down--;
            }else if(dir==3){
                for(int i=down;i>=up;i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            dir= (dir+1)%4;
        }
        return ans;
    }
}