class Solution {
public:
    int leftIndex=0, rightIndex=0;
    int maxLen = INT_MIN;
    string longestPalindrome(string s) {
        int n= s.length();
        for(int i=0;i<n;i++){
            findLP(s,i,i);
            findLP(s,i,i+1);
        }
        return s.substr(leftIndex, rightIndex-leftIndex+1);
    }
    void findLP(string s, int i, int j){
        int n = s.length();
        while(i>=0 && j<n &&s[i]==s[j]){
            i--;
            j++;
        }
        int len =j-i-1;
        if(len > maxLen){
            maxLen=len;
            leftIndex=i+1;
            rightIndex=j-1;
        }
    }
};