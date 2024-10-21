class Solution {
public:
    int leftIndex=0, rightIndex=0;
    int count = 0;
    int countSubstrings(string s) {
        int n= s.length();
        for(int i=0;i<n;i++){
            findLP(s,i,i);
            findLP(s,i,i+1);
        }
        return count ;
    }
    void findLP(string s, int i, int j){
        int n = s.length();
        while(i>=0 && j<n &&s[i]==s[j]){
            i--;
            j++;
            count++;
        }
        
    }
};