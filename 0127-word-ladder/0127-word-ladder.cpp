class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int len = beginWord.length();
        unordered_map<string,vector<string>>allComboDict;
        for(string word:wordList){
            for(int i=0;i<len;i++){
                string newWord = word.substr(0,i)+"*"+word.substr(i+1,len);
                allComboDict[newWord].push_back(word);
            }
        }
        //queue for BFS
        queue<pair<string,int>>Q;
        Q.push({beginWord,1});
        //visited to make sure we dont repeat the processing same word
        unordered_map<string,bool>visited;
        visited[beginWord]=true;
        while(!Q.empty()){
            pair p = Q.front();
            Q.pop();
            string word=p.first;
            int level = p.second;
            for(int i=0;i<len;i++){
                //intermediate for current word
                string newWord = word.substr(0,i)+"*"+word.substr(i+1,len);
                for(string adjWord:allComboDict[newWord]){
                    if(adjWord==endWord){
                        return level+1;
                    }
                    if(!visited[adjWord]){
                        visited[adjWord]=true;
                        Q.push(make_pair(adjWord,level+1));
                    }
                }
            }
        }
        return 0;
    }
};