class Solution {
public:
    string minWindow(string s, string t) {
        int arr[123]={0};
        for(char c:t){
            arr[c]++;
        }
        int minLen=INT_MAX, required=t.length();
        int left=0, right=0, start=0;
        int n=s.length();
        while(right < n){
            if(arr[s[right]]-- >0) required--;
            while(required==0){
                if(right-left+1 < minLen){
                    minLen=right-left+1;
                    start=left;
                }
                char leftChar = s[left];
                left++;
                if(arr[leftChar]++==0){
                    required++;
                }
            }

            right++;
        }
        if(minLen==INT_MAX) return "";
        return s.substr(start,minLen);
    }
};