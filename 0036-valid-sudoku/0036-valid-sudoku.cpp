class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_set<string>s;
        int n=board.size(),m=board[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    string rowCheck = to_string(ch)+"seen at row "+to_string(i);
                    string colCheck = to_string(ch)+"seen at col "+to_string(j);
                    string cellCheck = to_string(ch)+"seen at cell "+to_string(i/3)+"-"+to_string(j/3);

                    if(!s.insert(rowCheck).second || !s.insert(colCheck).second|| !s.insert(cellCheck).second){
                        return false;
                    }
                }
            }
        }
        return true;
    }
};