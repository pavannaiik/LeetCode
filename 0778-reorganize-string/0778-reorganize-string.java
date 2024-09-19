class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int max_c = 0;
        int n = s.length();
        int letter =0;
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
            if(max_c <freq[s.charAt(i)-'a'] ){
                max_c = freq[s.charAt(i)-'a'];
                letter = s.charAt(i)-'a';
            }
        }
        if(max_c > (n+1)/2){
            return "";
        }
        var ans = new char[n];
        int index =0;
        while(freq[letter] >0){
            ans[index]=(char)('a'+letter);
            index+=2;
            freq[letter]--;
        }
        for(int i=0;i<26;i++){
            while(freq[i]>0){
                if(index >= n){
                index =1;
            }
                ans[index]=(char)('a'+i);
                index+=2;
                freq[i]--;
            }
        }
        return String.valueOf(ans);
    }
}