class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>>ans;
        map<string,vector<string>>map;
        int count[26];
        for(string s:strs){
            string key = s;
            sort(key.begin(), key.end());
            map[key].push_back(s);
        }
        //auto& p:map
        for(auto p:map){
            ans.push_back(std::move(p.second));
        }
        return ans;
    }
};