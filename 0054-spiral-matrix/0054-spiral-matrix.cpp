class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int rows=matrix.size();
        int cols=matrix[0].size();
        int up=0,down=rows-1,left=0,right=cols-1;
        int dir=0;
        vector<int>ans;
        while(ans.size() <rows*cols){
            if(dir==0){
                //move left to right
                for(int i=left;i<=right;i++){
                    ans.push_back(matrix[up][i]);
                }
                up++;
            }else if(dir==1){
                //move from up to down using right
                for(int i=up;i<=down;i++){
                    ans.push_back(matrix[i][right]);
                }
                right--;
            }else if(dir==2){
                //move from right to left using down
                for(int i=right;i>=left;i--){
                    ans.push_back(matrix[down][i]);
                }
                down--;
            }else if(dir==3){
                //move down to up
                for(int i=down;i>=up;i--){
                    ans.push_back(matrix[i][left]);
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        return ans;
    }
};