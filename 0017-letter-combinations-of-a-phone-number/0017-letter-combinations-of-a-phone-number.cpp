class Solution {
public:
    vector<string>ans;
    unordered_map<char,string>map={{'2',"abc"},{'3',"def"},{'4',"ghi"}
    ,{'5',"jkl"},{'6',"mno"},{'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"}};
    vector<string> letterCombinations(string digits) {
        if(digits.length()==0) return ans;
        string s="";
        backtrack(digits,0,s);
        return ans;
    }
    void backtrack(string& digits,int index,string s){
        if(s.length()==digits.length()){
            ans.push_back(s);
            return;
        }
        string tmp=map[digits[index]];
        for(char c:tmp){
            s+=c;
            backtrack(digits,index+1,s);
            s.erase(s.length()-1);
        }
    }
};