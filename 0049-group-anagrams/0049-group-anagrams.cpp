class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>>ans;
        map<string,vector<string>>map;
        int count[26];
        for(string s:strs){
            fill(begin(count),end(count),0);
            for(char c:s) count[c-'a']++;
            string key="";
            for(int i:count){
                key+='#';
                key+=to_string(i);
            }
            if(map.find(key)==map.end()){
                map[key]=vector<string>();
            }
            map[key].push_back(s);
        }
        for(auto& p:map){
            ans.push_back(p.second);
        }
        return ans;
    }
};