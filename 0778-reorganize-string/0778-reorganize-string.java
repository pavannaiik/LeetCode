class Solution {
    public String reorganizeString(String s) {
        int[] charCountArray = new int[26];
        int n = s.length();
        int highestCount=0, index =-1;
        for(int i=0;i< n;i++){
            charCountArray[s.charAt(i)-'a']++;
            if(charCountArray[s.charAt(i)-'a'] > highestCount){
                highestCount=charCountArray[s.charAt(i)-'a'];
                index =s.charAt(i)-'a';
            }
        }
        if(highestCount > (n+1)/2){
            return "";
        }
        char[] ans = new char[s.length()];
        int i=0;
        while(charCountArray[index]-- > 0){
            ans[i]=(char)('a'+index);
            i=i+2;
        }
        for(int j=0;j<26;j++){
            while(charCountArray[j]-- >0){
                 if (i >= n) i = 1;
                ans[i]=(char)('a'+j);
                i = i+2;
            }
        }
        return String.valueOf(ans);
    }
}