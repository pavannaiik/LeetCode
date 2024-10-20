class Solution {
public:
    int characterReplacement(string s, int k) {
        int left=0, maxCount=0, maxLen=0;
        int arr[26];
        for(int right=0;right<s.length();right++){
            maxCount= max(maxCount, ++arr[s[right]-'A']);
            while(right-left+1-maxCount >k){
                arr[s[left]-'A']--;
                left++;
            }
            maxLen=max(maxLen, right-left+1);
        }
        return maxLen;
    }
};