class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        int left = 0;
        int n = s1.length(), m = s2.length();
        for(char c: s1.toCharArray()) s1Freq[c-'a']++;
        for(int right = 0;right <m ;right++){
            s2Freq[s2.charAt(right)-'a']++;
            if(right-left+1 > n){
                s2Freq[s2.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1 == n){
                int flag = 0;
                for(int i=0;i<26;i++){
                    if(s1Freq[i]!=s2Freq[i]) 
                    {
                        flag = 1;
                        break;
                    }
                }
                if(flag==0) return true;

            }

        }
        return false;
    }
}