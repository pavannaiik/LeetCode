class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int arr[26]={0};
        int brr[26]={0};
        for(char c:s1){
            arr[c-'a']++;
        }
        int left=0, right=0;
        while(right < s2.length()){
            brr[s2[right]-'a']++;
            
            if(right-left+1==s1.length()){
                if (equal(begin(arr), end(arr), begin(brr))) {
                    return true;
                }
                brr[s2[left]-'a']--;
                left++;
            }
            right++;
        }
        return false;

    }
};